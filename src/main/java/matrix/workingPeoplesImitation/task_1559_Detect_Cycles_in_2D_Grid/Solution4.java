package matrix.workingPeoplesImitation.task_1559_Detect_Cycles_in_2D_Grid;

// from leetcode code sample (2)
public class Solution4 {
    private static class UnionFind {
        private final int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }

        public boolean union(int x, int y) {
            if (x == y) {
                return false;
            }
            if (x > y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
            return true;
        }
    }

    public boolean containsCycle(char[][] grid) {
        final int m = grid.length;
        int n = grid[0].length;
        if (n == 0) {
            n = 1;
        }
        final UnionFind uf = new UnionFind(n * m);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //down step
                if (i > 0 && grid[i][j] == grid[i - 1][j]) {
                    int p1 = uf.find(i * n + j);
                    int p2 = uf.find((i - 1) * n + j);
                    if (!uf.union(p1, p2)) {
                        return true;  //p1 == p2
                    }
                }

                //right step.
                if (j > 0 && grid[i][j] == grid[i][j - 1]) {
                    int p1 = uf.find(i * n + j);
                    int p2 = uf.find(i * n + j - 1);
                    if (!uf.union(p1, p2)) {
                        return true; //p1 == p2
                    }
                }
            }
        }
        return false;
    }
}
