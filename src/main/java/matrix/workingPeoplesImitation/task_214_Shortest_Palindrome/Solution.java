package matrix.workingPeoplesImitation.task_214_Shortest_Palindrome;

// my solution
public class Solution {
    public String shortestPalindrome(String s) {
        if (s.equals("")) {
            return "";
        }
        if (isPalindrome(s, 0, s.length() - 1)) {
            return s;
        }
        int tail = Integer.MAX_VALUE;
        for (int i = s.length() / 2; i >= 0; i--) {
            if (isPalindromeParts(s, i, i + 2)) {
                if (i + i + 2 < s.length()) {
                    tail = i + i + 2;
                    break;
                }
            } else if (isPalindromeParts(s, i, i + 1)) {
                if (i + i + 1 < s.length()) {
                    tail = i + i + 1;
                    break;
                }
            }
        }
        if (tail == Integer.MAX_VALUE) {
            return getHead(s, 1);
        }
        return getHead(s, tail + 1);
    }
    private String getHead(String s, int index) {
        StringBuilder head = new StringBuilder();
        for (int i = s.length() - 1; i >= index; i--) {
            head.append(s.charAt(i));
        }
        return head.append(s).toString();
    }

    private boolean isPalindromeParts(String s, int left, int right) {
        while (left >= 0) {
            if (right >= s.length()) {
                return false;
            }
            if (s.charAt(left--) != s.charAt(right++)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int start, int end) {
        int count = (end - start) / 2 + 1;
        while (count-- > 0) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
