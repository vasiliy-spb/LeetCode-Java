package matrix.workingPeoplesImitation.task_2375_Construct_Smallest_Number_From_DI_String;

import java.util.Stack;

// from leetcode editorial (Approach 4: Using Stack)
public class Solution5 {

    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();

        // Iterate through the pattern
        for (int index = 0; index <= pattern.length(); index++) {
            // Push the next number onto the stack
            numStack.push(index + 1);

            // If 'I' is encountered or we reach the end, pop all stack elements
            if (index == pattern.length() || pattern.charAt(index) == 'I') {
                while (!numStack.isEmpty()) {
                    result.append(numStack.pop());
                }
            }
        }

        return result.toString();
    }
}
