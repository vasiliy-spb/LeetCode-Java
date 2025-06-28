package matrix.workingPeoplesImitation.task_946_Validate_Stack_Sequences;

import java.util.Stack;

// my solution
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushIndex = 0;
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();
        while (pushIndex < pushed.length && popIndex < popped.length) {
            while (pushIndex < pushed.length && pushed[pushIndex] != popped[popIndex]) {
                stack.push(pushed[pushIndex++]);
            }
            if (pushIndex < pushed.length && pushed[pushIndex] == popped[popIndex]) {
                stack.push(pushed[pushIndex++]);
            }
            while (!stack.empty() && popIndex < popped.length && popped[popIndex] == stack.peek()) {
                stack.pop();
                popIndex++;
            }
        }
        return pushIndex == pushed.length && popIndex == popped.length;
    }
}
