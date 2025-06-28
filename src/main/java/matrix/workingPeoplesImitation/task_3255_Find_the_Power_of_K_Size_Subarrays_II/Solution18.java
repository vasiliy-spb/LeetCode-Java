package matrix.workingPeoplesImitation.task_3255_Find_the_Power_of_K_Size_Subarrays_II;

import java.util.Stack;

// from leetcode code sample (16)
public class Solution18 {
    public int[] resultsArray(int[] nums, int k) {
        var stack = new Stack<Integer>();
        var ans = new int[nums.length - k + 1];
        int ansi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || (!stack.isEmpty() && stack.peek() == nums[i] - 1))
                stack.push(nums[i]);
            else {
                stack.clear();
                stack.push(nums[i]);
            }
            if (i >= k - 1) {
                if (stack.size() >= k)
                    ans[ansi++] = stack.peek();
                else
                    ans[ansi++] = -1;
            }
        }
        return ans;
    }
}
