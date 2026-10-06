package matrix.workingPeoplesImitation.task_1963_Minimum_Number_of_Swaps_to_Make_the_String_Balanced;

import java.util.Stack;

// from leetcode editorial (Approach 1: Stack)
public class Solution2 {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack();
        int unbalanced = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // If an opening bracket is encountered, push it in the stack.
            if (ch == '[') {
                stack.push(ch);
            } else {
                // If the stack is not empty, pop it.
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                // Otherwise increase the count of unbalanced brackets.
                else {
                    unbalanced++;
                }
            }
        }
        return (unbalanced + 1) / 2;
    }
}
