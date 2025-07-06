package matrix.workingPeoplesImitation.task_2734_Lexicographically_Smallest_String_After_Substring_Operation;

// my solution
public class Solution {
    public String smallestString(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int n = s.length();
        while (start < n && chars[start] == 'a') {
            start++;
        }
        if (start == n) {
            chars[n - 1] = 'z';
        }
        int end = start;
        while (end < n && chars[end] > 'a') {
            end++;
        }
        for (int i = start; i < end; i++) {
            chars[i]--;
        }
        return new String(chars);
    }
}
