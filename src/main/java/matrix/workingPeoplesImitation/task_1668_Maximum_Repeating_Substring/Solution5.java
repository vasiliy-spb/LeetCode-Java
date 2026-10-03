package matrix.workingPeoplesImitation.task_1668_Maximum_Repeating_Substring;

// from leetcode code sample (1)
public class Solution5 {
    public int maxRepeating(String sequence, String word) {
        int maxi = 0;
        int n = sequence.length();
        int m = word.length();
        int[] dp = new int[n + 1];
        for (int i = m; i <= n; i++) {
            if (sequence.substring(i - m, i).equals(word)) {
                dp[i] = dp[i - m] + 1;
            }

            maxi = Math.max(dp[i], maxi);
        }
        return maxi;
    }
}
