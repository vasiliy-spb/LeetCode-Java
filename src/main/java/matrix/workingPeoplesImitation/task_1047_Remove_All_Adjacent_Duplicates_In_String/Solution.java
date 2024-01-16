package matrix.workingPeoplesImitation.task_1047_Remove_All_Adjacent_Duplicates_In_String;

import java.util.Stack;

public class Solution {

    // my solution
    public String removeDuplicates(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && stack.peek() == s.charAt(i)) stack.pop();
            else stack.push(s.charAt(i));
        }
        for (char ch : stack)
            result.append(ch);
        return result.toString();
    }

    // from leetcode solutions
    public String removeDuplicates2(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) {
                sb.deleteCharAt(size - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
