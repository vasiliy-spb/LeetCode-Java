package matrix.workingPeoplesImitation.task_1668_Maximum_Repeating_Substring;

import java.util.Arrays;

// my solution (WA)
public class Solution {
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();
        int[][] dp = new int[m][n];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (j > 0) {
                    dp[j][i] = dp[j - 1][i];
                }
                if (sequence.charAt(i) == word.charAt(j)) {
                    if (i > 0 && j > 0 && dp[j][i] >= j - 1
                        && i >= j && dp[j][i - j] == 1
                    ) {
                        dp[j][i] = j + 1;
//                        dp[j][i]++;
                    }
                    if (j == 0) {
                        dp[j][i]++;
                    }
                }
            }
        }
        printDp(dp);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dp[m - 1][i] == word.length() && i >= word.length() - 1 && dp[m - 1][i - (word.length() - 1)] == 1) {
//            if (dp[m - 1][i] == word.length()) {
                count++;
            }
        }
        return count;
//        return Arrays.stream(dp[m - 1])
//                       .filter(num -> num == word.length())
//                       .sum() / word.length();
    }

    private void printDp(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

/*

a b

a b a b c

1 0 1 0 0
1 1 1 1 0



a b a

a b a b a c

1 0 1 0 1 0
1 1 1 1 1 0


 */


