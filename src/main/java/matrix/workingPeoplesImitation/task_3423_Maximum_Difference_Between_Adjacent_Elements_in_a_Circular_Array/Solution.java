package matrix.workingPeoplesImitation.task_3423_Maximum_Difference_Between_Adjacent_Elements_in_a_Circular_Array;

// my solution
public class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int diff = 0;
        for (int i = 0; i <= n; i++) {
            diff = Math.max(diff, Math.abs(nums[i % n] - nums[(i + 1) % n]));
        }
        return diff;
    }
}
