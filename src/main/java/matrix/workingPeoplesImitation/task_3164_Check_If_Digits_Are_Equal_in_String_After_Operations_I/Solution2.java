package matrix.workingPeoplesImitation.task_3164_Check_If_Digits_Are_Equal_in_String_After_Operations_I;

import java.util.Stack;

// my solution (slower)
public class Solution2 {
    public boolean hasSameDigits(String s) {
        Stack<Integer> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            stack.push(ch - '0');
        }

        while (stack.size() > 2) {
            Stack<Integer> temp = new Stack<>();
            while (stack.size() > 1) {
                temp.push((stack.pop() + stack.peek()) % 10);
            }
            stack = temp;
        }
        return stack.pop() == stack.pop();
    }
}
