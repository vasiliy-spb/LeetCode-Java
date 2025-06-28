package matrix.workingPeoplesImitation.task_214_Shortest_Palindrome;

// from leetcode code sample (6)
public class Solution13 {
    // Function to compute the LPS (Longest Prefix Suffix) array for KMP algorithm
    public int[] computeLPS(String s) {
        int[] lps = new int[s.length()];
        int length = 0;  // Length of the previous longest prefix suffix
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

    public String shortestPalindrome(String s) {
        if (s.length() == 0) return "";

        // Reverse the string
        String rev_s = new StringBuilder(s).reverse().toString();

        // Concatenate s + "#" + rev_s
        String concatenated = s + "#" + rev_s;

        // Compute LPS array for the concatenated string
        int[] lps = computeLPS(concatenated);

        // The last value of the LPS array gives us the length of the longest palindrome
        // starting from the beginning of `s`.
        int len = lps[lps.length - 1];

        // Append the reverse of the remaining suffix to the front of the original string
        String remainingSuffix = s.substring(len);
        StringBuilder ans = new StringBuilder(remainingSuffix).reverse();
        ans.append(s);

        return ans.toString();
    }
}
