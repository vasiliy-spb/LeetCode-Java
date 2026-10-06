package matrix.workingPeoplesImitation.task_1963_Minimum_Number_of_Swaps_to_Make_the_String_Balanced;

import java.util.Stack;

// my solution
public class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ']') {
                if (!stack.empty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.size() / 4 + (stack.size() % 4 == 0 ? 0 : 1);
    }
}
