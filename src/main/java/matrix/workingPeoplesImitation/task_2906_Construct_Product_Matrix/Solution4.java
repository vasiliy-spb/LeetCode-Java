package matrix.workingPeoplesImitation.task_2906_Construct_Product_Matrix;

// from leetcode code sample (1)
public class Solution4 {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mod = 12345;
        long[] pre = new long[n * m];
        long[] suf = new long[n * m];
        pre[0] = 1L;
        int prev = grid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = (i == 0 ? 1 : 0); j < m; j++) {
                pre[i * m + j] = (pre[i * m + j - 1] * prev) % mod;
                prev = grid[i][j];
            }
        }
        suf[n * m - 1] = 1L;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = (i == n - 1 ? m - 2 : m - 1); j >= 0; j--) {
                suf[i * m + j] = (suf[i * m + j + 1] * prev) % mod;
                prev = grid[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = (int) ((pre[i * m + j] * suf[i * m + j]) % mod);
            }
        }
        return grid;
    }
}
