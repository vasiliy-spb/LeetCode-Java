package matrix.workingPeoplesImitation.task_1668_Maximum_Repeating_Substring;

import java.util.Arrays;

// my solution (WA)
public class Solution3 {
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();
        int[] dp = new int[n];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (sequence.charAt(i) == word.charAt(j)) {
                    if (j == 0) {
                        dp[i]++;
                        continue;
                    }
                    if (i > 0
                        && dp[i - 1] == j
                    ) {
                        dp[i] = j + 1;
//                        dp[i] = dp[i - 1] + 1;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == word.length()) {
                for (int j = i; j < n; j += word.length()) {
                    if (dp[j] < word.length()) {
                        break;
                    }
                    count = Math.max(count, (j - i) / word.length() + 1);
                }
            }
        }
        return count;
    }
}
