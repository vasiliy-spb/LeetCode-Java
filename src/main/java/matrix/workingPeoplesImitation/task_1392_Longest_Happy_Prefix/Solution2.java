package matrix.workingPeoplesImitation.task_1392_Longest_Happy_Prefix;

// my solution modernized DeepSeek
public class Solution2 {
    public String longestPrefix(String s) {
        int n = s.length();
        if (n == 1) return "";

        final int base = 143;
        final int modulo = 1000000007;

        long[] power = new long[n + 1];
        power[0] = 1;
        for (int i = 1; i <= n; i++) {
            power[i] = (power[i - 1] * base) % modulo;
        }

        long[] hash = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            hash[i] = (hash[i - 1] * base + s.charAt(i - 1)) % modulo;
        }

        int maxLen = 0;
        for (int len = 1; len < n; len++) {
            long prefixHash = hash[len];
            long suffixHash = (hash[n] - hash[n - len] * power[len] % modulo + modulo) % modulo;
            if (prefixHash == suffixHash) {
                maxLen = len;
            }
        }

        return s.substring(0, maxLen);
    }
}
