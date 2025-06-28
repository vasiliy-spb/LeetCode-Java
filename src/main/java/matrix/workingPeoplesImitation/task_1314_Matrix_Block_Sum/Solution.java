package matrix.workingPeoplesImitation.task_1314_Matrix_Block_Sum;

public class Solution {

    // my solution
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] prefixSum = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefixSum[i][j] += mat[i][j];
                if (j > 0) {
                    prefixSum[i][j] += prefixSum[i][j - 1];
                }
            }
        }
        int[][] answer = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer[i][j] = calculateBlockSum(mat, i, j, k, prefixSum);
            }
        }
        return answer;
    }

    private int calculateBlockSum(int[][] mat, int i, int j, int k, int[][] prefixSum) {
        int sum = 0;
        int up = Math.max(0, i - k);
        int left = Math.max(0, j - k);
        int right = Math.min(mat[0].length - 1, j + k);
        int bottom = Math.min(mat.length - 1, i + k);
        for (int l = up; l <= bottom; l++) {
                sum += prefixSum[l][right];
            if (j - k > 0) {
                sum -= prefixSum[l][left - 1];
            }
        }
        return sum;
    }

    // from walkccc.me
    public int[][] matrixBlockSum2(int[][] mat, int k) {
        final int m = mat.length;
        final int n = mat[0].length;
        int[][] ans = new int[m][n];
        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                prefix[i + 1][j + 1] = mat[i][j] + prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j];

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                final int r1 = Math.max(0, i - k) + 1;
                final int c1 = Math.max(0, j - k) + 1;
                final int r2 = Math.min(m - 1, i + k) + 1;
                final int c2 = Math.min(n - 1, j + k) + 1;
                ans[i][j] =
                        prefix[r2][c2] - prefix[r2][c1 - 1] - prefix[r1 - 1][c2] + prefix[r1 - 1][c1 - 1];
            }

        return ans;
    }

}

/*

[1,2,3],
[4,5,6],
[7,8,9]]

[12,21,16],
[27,45,33],
[24,39,28]

 */
// 1 2 3 4 5 6 7 8 9