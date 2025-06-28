package matrix.workingPeoplesImitation.task_214_Shortest_Palindrome;

// from leetcode code sample (1)
public class Solution8 {
    public String shortestPalindrome(String s) {
        int n = s.length(), pos = -1;
        long B = 26, MOD = 1000000007, POW = 1, hash1 = 0, hash2 = 0;
        for (int i = 0; i < n; i++, POW = POW * B % MOD) {
            hash1 = (hash1 * B + s.charAt(i) - 'a' + 1) % MOD;
            hash2 = (hash2 + (s.charAt(i) - 'a' + 1) * POW) % MOD;
            if (hash1 == hash2) pos = i;
        }
        return new StringBuilder().append(s.substring(pos + 1, n)).reverse().append(s).toString();
    }
}
