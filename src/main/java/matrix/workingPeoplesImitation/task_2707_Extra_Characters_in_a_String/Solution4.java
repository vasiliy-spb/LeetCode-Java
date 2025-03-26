package matrix.workingPeoplesImitation.task_2707_Extra_Characters_in_a_String;

import java.util.Arrays;
import java.util.HashSet;

// from leetcode editorial (Approach 2: Bottom Up Dynamic Programming with Substring Method)
public class Solution4 {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        var dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        var dp = new int[n + 1];

        for (int start = n - 1; start >= 0; start--) {
            dp[start] = dp[start + 1] + 1;
            for (int end = start; end < n; end++) {
                var curr = s.substring(start, end + 1);
                if (dictionarySet.contains(curr)) {
                    dp[start] = Math.min(dp[start], dp[end + 1]);
                }
            }
        }

        return dp[0];
    }
}
