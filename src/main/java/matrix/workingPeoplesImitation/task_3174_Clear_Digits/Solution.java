package matrix.workingPeoplesImitation.task_3174_Clear_Digits;

import java.util.Stack;

// my solution
public class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (!stack.empty() && !Character.isDigit(stack.peek())) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.empty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
