package matrix.workingPeoplesImitation.task_209_Minimum_Size_Subarray_Sum;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length + 1;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                length = Math.min(length, right - left + 1);
                sum -= nums[left++];
            }
        }
        return length > nums.length ? 0 : length;
    }
}
