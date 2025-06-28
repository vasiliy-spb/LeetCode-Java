package matrix.workingPeoplesImitation.task_5_Longest_Palindromic_Substring;

public class Solution {
    public String longestPalindrome(String s) {
        StringBuilder result = new StringBuilder();
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (j - i + 1 > length && isPalindrome(s, i, j)) {
                    length = j - i + 1;
                    result = new StringBuilder(s.substring(i, j + 1));
                }
            }
        }
        return result.toString();
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
