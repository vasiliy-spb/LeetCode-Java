package matrix.workingPeoplesImitation.task_1544_Make_The_String_Great;

import java.util.Locale;
import java.util.Stack;

public class Solution {

    // my solution
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.empty()) stack.push(ch);
            else {
                if (stack.peek() != ch && String.valueOf(stack.peek()).equalsIgnoreCase(String.valueOf(ch)))
                    stack.pop();
                else stack.push(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.empty())
            result.insert(0, stack.pop());
        return result.toString();
    }

    // from walkccc.me
    public String makeGood2(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray())
            if (sb.length() > 0 && isBadPair(sb.charAt(sb.length() - 1), c))
                sb.deleteCharAt(sb.length() - 1);
            else
                sb.append(c);
        return sb.toString();
    }

    private boolean isBadPair(char a, char b) {
        return a != b && Character.toLowerCase(a) == Character.toLowerCase(b);
    }
}
