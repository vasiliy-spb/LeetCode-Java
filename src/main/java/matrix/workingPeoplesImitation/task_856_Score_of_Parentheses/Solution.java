package matrix.workingPeoplesImitation.task_856_Score_of_Parentheses;

import java.util.Stack;

// my solution
public class Solution {
    public int scoreOfParentheses(String s) {
        Stack<String> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch != ')') {
                stack.push("(");
                continue;
            }

            String current = stack.pop();
            if (current.equals("(")) {
                stack.push("1");
                continue;
            }

            int num = 0;
            while (isInteger(current)) {
                num += Integer.parseInt(current);
                current = stack.pop();
            }
            stack.push((num * 2) + "");
        }

        int ans = 0;
        while (!stack.empty()) {
            ans += Integer.parseInt(stack.pop());
        }
        return ans;
    }

    private boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
