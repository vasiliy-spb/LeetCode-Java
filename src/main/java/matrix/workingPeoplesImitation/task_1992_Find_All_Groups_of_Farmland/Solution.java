package matrix.workingPeoplesImitation.task_1992_Find_All_Groups_of_Farmland;

import java.util.*;

public class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> borders = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1) {
                    borders.add(new int[]{i, j, -1, -1});
                    findBorder(land, borders, i, j);
                }
            }
        }
        return borders.toArray(int[][]::new);
    }

    private final int[] directionsI = {1, 0};
    private final int[] directionsJ = {0, 1};

    private void findBorder(int[][] land, List<int[]> borders, int i, int j) {
        if (land[i][j] == 0 || land[i][j] == 2) return;
        land[i][j] = 2;
        if ((i + 1 == land.length || land[i + 1][j] == 0)
                && (j + 1 == land[i].length || land[i][j + 1] == 0)) {
            borders.get(borders.size() - 1)[2] = i;
            borders.get(borders.size() - 1)[3] = j;
        }
        for (int d = 0; d < 2; d++) {
            int nextI = i + directionsI[d];
            int nextJ = j + directionsJ[d];
            if (nextI >= 0 && nextI < land.length && nextJ >= 0 && nextJ < land[nextI].length) {
                findBorder(land, borders, nextI, nextJ);
            }
        }
    }

    // from walkccc.me
    public int[][] findFarmland5(int[][] land) {
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < land.length; ++i)
            for (int j = 0; j < land[0].length; ++j)
                if (land[i][j] == 1) {
                    int[] cell = new int[] {i, j};
                    dfs(land, i, j, cell);
                    ans.add(new int[] {i, j, cell[0], cell[1]});
                }

        return ans.stream().toArray(int[][] ::new);
    }

    private void dfs(int[][] land, int i, int j, int[] cell) {
        if (i < 0 || i == land.length || j < 0 || j == land[0].length)
            return;
        if (land[i][j] != 1)
            return;
        land[i][j] = 2; // Mark as visited.
        cell[0] = Math.max(cell[0], i);
        cell[1] = Math.max(cell[1], j);
        dfs(land, i + 1, j, cell);
        dfs(land, i, j + 1, cell);
    }

    // from leetcode editorial (Approach 1: Depth-First Search)
    // The four directions in which traversal will be done.
    int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    // Global variables with 0 value initially.
    int row2, col2;

    // Returns true if the coordinate is within the boundary of the matrix.
    private boolean isWithinFarm(int x, int y, int N, int M) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private void DFS(int[][] land, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        // Maximum x and y for the bottom right cell.
        row2 = Math.max(row2, x); col2 = Math.max(col2, y);

        for (int[] dir : dirs) {
            // Neighbor cell coordinates.
            int newX = x + dir[0], newY = y + dir[1];

            // If the neighbor is within the matrix and is a farmland cell and is not visited yet.
            if (isWithinFarm(newX, newY, land.length, land[0].length) && !visited[newX][newY]
                    && land[newX][newY] == 1) {
                DFS(land, visited, newX, newY);
            }
        }
    }

    public int[][] findFarmland2(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        List<int[]> ans = new ArrayList<>();

        for (int row1 = 0; row1 < land.length; row1++) {
            for (int col1 = 0; col1 < land[0].length; col1++) {
                if (land[row1][col1] == 1 && !visited[row1][col1]) {
                    row2 = 0; col2 = 0;

                    DFS(land, visited, row1, col1);

                    int[] arr = new int[] {row1, col1, row2, col2};
                    ans.add(arr);
                }
            }
        }

        return ans.stream().toArray(int[][] :: new);
    }

    // from leetcode editorial (Approach 2: Breadth-First Search)
    // The four directions in which traversal will be done.
    class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    int[][] dirs2 = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    // Returns true if the coordinate is within the boundary of the matrix.
    private boolean isWithinFarm2(int x, int y, int N, int M) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private Pair<Integer, Integer> BFS(Queue<Pair<Integer, Integer>> q, int[][] land,
                                       boolean[][] visited) {
        Pair<Integer, Integer> curr = new Pair<Integer, Integer>(0, 0);

        while (!q.isEmpty()) {
            curr = q.remove();

            int x = curr.getKey();
            int y = curr.getValue();

            for (int[] dir : dirs2) {
                // Neighbor cell coordinates.
                int newX = x + dir[0], newY = y + dir[1];

                // If the neighbor is within the matrix and is a farmland cell and not visited yet.
                if (isWithinFarm2(newX, newY, land.length, land[0].length) && !visited[newX][newY]
                        && land[newX][newY] == 1) {
                    visited[newX][newY] = true;
                    q.add(new Pair(newX, newY));
                }
            }
        }

        return curr;
    }

    public int[][] findFarmland3(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        List<int[]> ans = new ArrayList<>();


        for (int row1 = 0; row1 < land.length; row1++) {
            for (int col1 = 0; col1 < land[0].length; col1++) {
                if (land[row1][col1] == 1 && !visited[row1][col1]) {
                    Queue<Pair<Integer, Integer>> q = new LinkedList<>();

                    q.add(new Pair(row1, col1));
                    visited[row1][col1] = true;

                    Pair<Integer, Integer> last = BFS(q, land, visited);

                    int[] arr = new int[] {row1, col1, last.getKey(), last.getValue()};
                    ans.add(arr);
                }
            }
        }

        return ans.stream().toArray(int[][] :: new);
    }

    // from leetcode editorial (Approach 3: Greedy)
    public int[][] findFarmland4(int[][] land) {
        int N = land.length, M = land[0].length;
        List<int[]> ans = new ArrayList<>();

        for (int row1 = 0; row1 < N; row1++) {
            for (int col1 = 0; col1 < M; col1++) {
                if (land[row1][col1] == 1) {
                    int x = row1, y = col1;

                    for (x = row1; x < N && land[x][col1] == 1; x++) {
                        for (y = col1; y < M && land[x][y] == 1; y++) {
                            land[x][y] = 0;
                        }
                    }

                    int[] arr = new int[] {row1, col1, x - 1, y - 1};
                    ans.add(arr);
                }
            }
        }
        return ans.stream().toArray(int[][] :: new);
    }

}
