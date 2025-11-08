package matrix.workingPeoplesImitation.task_2216_Minimum_Deletions_to_Make_Array_Beautiful;

import java.util.Stack;

// my solution
public class Solution {
    public int minDeletion(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if (stack.size() % 2 == 1 && stack.peek() == num) {
                continue;
            }
            stack.push(num);
        }
        return nums.length - stack.size() + stack.size() % 2;
    }
}
