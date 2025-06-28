package matrix.workingPeoplesImitation.task_3105_Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray;

// my solution
public class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        boolean increasing = nums[1] > nums[0];
        boolean decreasing = nums[1] < nums[0];
        int maxLength = 1;
        int currentLength = nums[1] == nums[0] ? 0 : 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                currentLength = 1;
                continue;
            }
            if (nums[i] > nums[i - 1]) {
                currentLength = increasing ? currentLength + 1 : 2;
            }
            if (nums[i] < nums[i - 1]) {
                currentLength = decreasing ? currentLength + 1 : 2;
            }
            increasing = nums[i] > nums[i - 1];
            decreasing = nums[i] < nums[i - 1];
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}
