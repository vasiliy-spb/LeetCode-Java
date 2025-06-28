package matrix.workingPeoplesImitation.task_1392_Longest_Happy_Prefix;

// my solution
public class Solution {
    public String longestPrefix(String s) {
        int originalLength = s.length();
        s = " " + s;
        final int modulo = 1000000007;
        final int base = 143;
        int n = s.length();
        long[] power = new long[n];
        power[0] = 1;
        for (int i = 1; i < power.length; i++) {
            power[i] = power[i - 1] * base % modulo;
        }
        long[] hash = new long[n];
        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            hash[i] = (hash[i - 1] * base % modulo + ch) % modulo;
        }
        int max = 0;
        for (int length = 0; length < n; length++) {
            int head1 = 1;
            int tail1 = head1 + length;
            int tail2 = n - 1;
            int head2 = tail2 - length;
            if (head2 < 0 || tail1 >= n) {
                break;
            }

            long hash1 = hash[length];
            long hash2 = (hash[tail2] - (hash[head2] * power[length] + modulo) % modulo + modulo) % modulo;

            if (hash1 == hash2) {
                if (length < originalLength) {
                    max = Math.max(max, length + 1);
                }
            }
        }
        return s.substring(1, max);
    }
}
