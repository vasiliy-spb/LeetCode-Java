package matrix.workingPeoplesImitation.task_214_Shortest_Palindrome;

// from leetcode code sample (5)
public class Solution12 {
    private final int BASE = 31;
    private final int MOD = (int) 1e9 + 9;
    private final int ASCII_CODE_OFFSET = 97;

    public String shortestPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reversed;

        int[] lps = buildLPS(combined);
        int longestPalindromicPrefixLength = lps[lps.length - 1];

        String suffixToAdd = s.substring(longestPalindromicPrefixLength);
        return new StringBuilder(suffixToAdd).reverse().toString() + s;
    }

    private int[] buildLPS(String s) {
        int[] lps = new int[s.length()];
        int length = 0;
        int i = 1;

        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
