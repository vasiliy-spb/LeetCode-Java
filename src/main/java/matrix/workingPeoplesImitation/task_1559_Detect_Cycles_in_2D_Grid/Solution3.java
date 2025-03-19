package matrix.workingPeoplesImitation.task_1559_Detect_Cycles_in_2D_Grid;

// from leetcode code sample (1)
public class Solution3 {
    public boolean containsCycle(char[][] grid) {
        return isCycle(grid);
    }

    static boolean isCycle(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] parent = new int[n * m];
        for (int i = 0; i < n * m; i++) parent[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0 && grid[i][j] == grid[i - 1][j]) {
                    if (find(i * m + j, parent) == find((i - 1) * m + j, parent)) return true;
                    union(i * m + j, (i - 1) * m + j, parent);
                }
                if (j > 0 && grid[i][j] == grid[i][j - 1]) {
                    if (find(i * m + j, parent) == find(i * m + (j - 1), parent)) return true;
                    union(i * m + j, i * m + (j - 1), parent);
                }
            }
        }
        return false;
    }

    static int find(int x, int[] parent) {
        if (parent[x] != x) parent[x] = find(parent[x], parent);
        return parent[x];
    }

    static void union(int a, int b, int[] parent) {
        int p1 = find(a, parent);
        int p2 = find(b, parent);
        if (p1 != p2) parent[p1] = p2;
    }
}
