package matrix.workingPeoplesImitation.task_2390_Removing_Stars_From_a_String;

import java.util.Stack;

public class Solution {

    // my solution
    public String removeStars(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*' && !stack.empty()) stack.pop();
            else stack.push(s.charAt(i));
        }
        while (!stack.isEmpty())
            result.insert(0, stack.pop());
        return result.toString();
    }

    // from walkccc.me

    public String removeStars2(String s) {
        StringBuilder sb = new StringBuilder();
        for (final char c : s.toCharArray())
            if (c == '*')
                sb.deleteCharAt(sb.length() - 1);
            else
                sb.append(c);
        return sb.toString();
    }
}
