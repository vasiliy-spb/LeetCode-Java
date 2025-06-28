package matrix.workingPeoplesImitation.task_1143_Longest_Common_Subsequence;

public class Solution {

    // my solution
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
//        for (int[] arr : dp) {
//            for (int i : arr) {
//                System.out.print(i + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println();
        return dp[n][m];
    }

    // from walkccc.me
    public int longestCommonSubsequence2(String text1, String text2) {
        final int m = text1.length();
        final int n = text2.length();
        // dp[i][j] := the length of LCS(text1[0..i), text2[0..j))
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                dp[i + 1][j + 1] = text1.charAt(i) == text2.charAt(j)
                        ? 1 + dp[i][j]
                        : Math.max(dp[i][j + 1], dp[i + 1][j]);

        return dp[m][n];
    }

}
