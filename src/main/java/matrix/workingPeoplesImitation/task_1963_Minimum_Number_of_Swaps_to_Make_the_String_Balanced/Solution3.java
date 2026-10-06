package matrix.workingPeoplesImitation.task_1963_Minimum_Number_of_Swaps_to_Make_the_String_Balanced;

// from leetcode editorial (Approach 2: Space-Optimized Stack)
public class Solution3 {
    public int minSwaps(String s) {
        int stackSize = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // If character is opening bracket, increment the stack size.
            if (ch == '[') {
                stackSize++;
            } else {
                // If the character is closing bracket, and we have an opening bracket, decrease
                // the stack size.
                if (stackSize > 0) {
                    stackSize--;
                }
            }
        }
        return (stackSize + 1) / 2;
    }
}
