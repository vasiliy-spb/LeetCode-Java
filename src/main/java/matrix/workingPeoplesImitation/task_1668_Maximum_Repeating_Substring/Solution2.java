package matrix.workingPeoplesImitation.task_1668_Maximum_Repeating_Substring;

// my solution (WA)
public class Solution2 {
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
                        && dp[i - 1] >= j
                    ) {
//                        if (i >= j && dp[i - j] != 1) {
//                        if (i >= j && dp[i - j] < 1) {
//                            continue;
//                        }
                        dp[i] = j + 1;
//                        dp[i] = dp[i - 1] + 1;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        int count = 0;
        for (int i = 0; i < n; ) {
            if (
//                    i >= word.length() - 1 &&
                    dp[i] >= word.length()
//                && dp[i - (word.length() - 1)] == 1
            ) {
                count++;
                i += word.length();
            } else {
                i++;
            }
        }
        return Math.min(count, word.length());
    }
}
