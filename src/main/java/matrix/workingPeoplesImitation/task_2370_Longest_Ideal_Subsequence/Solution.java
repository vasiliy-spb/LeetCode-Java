package matrix.workingPeoplesImitation.task_2370_Longest_Ideal_Subsequence;

import java.util.*;

public class Solution {

    // my solution
    public int longestIdealString(String s, int k) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            Map<Character, Integer> replaceCharMap = new HashMap<>();
            boolean concat = false;
            for (char ch : charMap.keySet()) {
                if (Math.abs(currentChar - ch) <= k) {
                    concat = true;
                    if (charMap.containsKey(currentChar))
                        replaceCharMap.merge(currentChar, Math.max(replaceCharMap.getOrDefault(currentChar, 0), Math.max(charMap.get(currentChar), charMap.getOrDefault(ch, 0)) + 1), Integer::max);
                    else
                        replaceCharMap.merge(currentChar, Math.max(replaceCharMap.getOrDefault(currentChar, 0), charMap.getOrDefault(ch, 0) + 1), Integer::max);
                }
            }
            if (!concat)
                charMap.merge(currentChar, 1, Integer::sum);
            else
                replaceCharMap.entrySet().stream().forEach(entry -> charMap.put(entry.getKey(), entry.getValue()));
        }
        return charMap.values().stream().max(Integer::compareTo).get();
    }

    // from leetcode editorial (Approach 1: Recursive Dynamic Programming (Top Down))
    public int longestIdealString2(String s, int k) {
        int N = s.length();

        // Initialize all dp values to -1 to indicate non-visited states
        int[][] dp = new int[N][26];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Find the maximum dp[N-1][c] and return the result
        int res = 0;
        for (int c = 0; c < 26; c++) {
            res = Math.max(res, dfs(N - 1, c, dp, s, k));
        }
        return res;
    }

    public int dfs(int i, int c, int[][] dp, String s, int k) {
        // Memoized value
        if (dp[i][c] != -1) {
            return dp[i][c];
        }

        // State is not visited yet
        dp[i][c] = 0;
        boolean match = c == (s.charAt(i) - 'a');
        if (match) {
            dp[i][c] = 1;
        }

        // Non base case handling
        if (i > 0) {
            dp[i][c] = dfs(i - 1, c, dp, s, k);
            if (match) {
                for (int p = 0; p < 26; p++) {
                    if (Math.abs(c - p) <= k) {
                        dp[i][c] = Math.max(dp[i][c], dfs(i - 1, p, dp, s, k) + 1);
                    }
                }
            }
        }
        return dp[i][c];
    }

    // from leetcode editorial (Approach 2: Iterative Dynamic Programming (Bottom Up, Space Optimized))
    public int longestIdealString3(String s, int k) {
        int N = s.length();
        int[] dp = new int[26];

        int res = 0;
        // Updating dp with the i-th character
        for (int i = 0; i < N; i++) {
            int curr = s.charAt(i) - 'a';
            int best = 0;
            for (int prev = 0; prev < 26; prev++) {
                if (Math.abs(prev - curr) <= k) {
                    best = Math.max(best, dp[prev]);
                }
            }

            // Appending s[i] to the previous longest ideal subsequence allowed
            dp[curr] = Math.max(dp[curr], best + 1);
            res = Math.max(res, dp[curr]);
        }
        return res;
    }

    // from walkccc.me
    public int longestIdealString4(String s, int k) {
        // dp[i] := the longest subsequence that ends in ('a' + i)
        int[] dp = new int[26];

        for (final char c : s.toCharArray()) {
            final int i = c - 'a';
            dp[i] = 1 + getMaxReachable(dp, i, k);
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    private int getMaxReachable(int[] dp, int i, int k) {
        final int first = Math.max(0, i - k);
        final int last = Math.min(25, i + k);
        int maxReachable = 0;
        for (int j = first; j <= last; ++j)
            maxReachable = Math.max(maxReachable, dp[j]);
        return maxReachable;
    }
}
