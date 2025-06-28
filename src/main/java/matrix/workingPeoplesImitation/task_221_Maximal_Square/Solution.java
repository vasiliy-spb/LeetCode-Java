package matrix.workingPeoplesImitation.task_221_Maximal_Square;

public class Solution {

    // my solution
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxSquare = 0;
        for (int i = 0; i < n; i++) {
            line:
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (j > 0) dp[i][j] = dp[i][j - 1] + 1;
                    else dp[i][j] = 1;
                    if (i > 0 && j > 0) {
                        int height = Math.min(i + 1, dp[i][j]);
                        for (int k = 0; k < height; k++) {
                            if (i - k < 0 || dp[i - k][j] == 0) continue line;
                            if (k + 1 > dp[i - k][j]) continue line;
                            height = Math.min(height, dp[i - k][j]);
                            maxSquare = Math.max(maxSquare, (k + 1) * (k + 1));
                        }
                         maxSquare = Math.max(maxSquare, height * height);
                    }
                    maxSquare = Math.max(maxSquare, 1);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(dp[i][j]);
//                System.out.print("\t");
//            }
//            System.out.println();
//        }
        return maxSquare;
    }

    // from walkccc.me (Approach 1: 2D DP)
    public int maximalSquare2(char[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLength = 0;

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0 || matrix[i][j] == '0')
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                maxLength = Math.max(maxLength, dp[i][j]);
            }

        return maxLength * maxLength;
    }

    // from walkccc.me (Approach 2: 1D DP)
    public int maximalSquare3(char[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int[] dp = new int[n];
        int maxLength = 0;
        int prev = 0; // dp[i - 1][j - 1]

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                final int cache = dp[j];
                if (i == 0 || j == 0 || matrix[i][j] == '0')
                    dp[j] = matrix[i][j] == '1' ? 1 : 0;
                else
                    dp[j] = Math.min(prev, Math.min(dp[j], dp[j - 1])) + 1;
                maxLength = Math.max(maxLength, dp[j]);
                prev = cache;
            }

        return maxLength * maxLength;
    }

}
