package matrix.workingPeoplesImitation.task_1391_Check_if_There_is_a_Valid_Path_in_a_Grid;

import java.util.LinkedList;
import java.util.Queue;

// from leetcode code sample (6)
public class Solution8 {
    int[][][] dirs = {
            {{0, -1}, {0, 1}},
            {{-1, 0}, {1, 0}},
            {{0, -1}, {1, 0}},
            {{0, 1}, {1, 0}},
            {{0, -1}, {-1, 0}},
            {{0, 1}, {-1, 0}}
    };

    public boolean hasValidPath(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<int[]>();

        // starting position
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];

            int num = grid[x][y] - 1;
            // explore possilbe neigbors
            for (int[] dir : dirs[num]) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // check if this is on board or already visited
                if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length || visited[nx][ny]) {
                    continue;
                }

                // we need to check if from the next possible there is a path back, or they are connected, only then we can explore this
                int nNum = grid[nx][ny] - 1;

                for(int[] backDir : dirs[nNum]) {
                    int backX = nx + backDir[0];
                    int backY = ny + backDir[1];
                    if (backX == x && backY == y) {
                        // we can get to last pos
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        // there is a backpath, check we have reached end already
                        if (nx == grid.length-1 && ny == grid[0].length-1) {
                            return true;
                        }
                    }
                }
            }
        }
        return visited[grid.length-1][grid[0].length-1];
    }
}
