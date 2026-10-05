package matrix.workingPeoplesImitation.task_856_Score_of_Parentheses;

import java.util.Stack;

// from leetcode code sample (3)
public class Solution4 {
    public int scoreOfParentheses(String s) {
        //using stack
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int value = 0;
                while (stack.peek() != 0) {
                    value = value + stack.pop();
                }
                stack.pop();
                stack.push(value == 0 ? 1 : 2 * value);
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result = result + stack.pop();
        }
        return result;
    }
}
