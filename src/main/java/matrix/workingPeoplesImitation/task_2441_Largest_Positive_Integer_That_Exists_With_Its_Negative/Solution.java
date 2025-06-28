package matrix.workingPeoplesImitation.task_2441_Largest_Positive_Integer_That_Exists_With_Its_Negative;

import java.util.Arrays;

public class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right && nums[right] >= 0) {
            if (nums[left] < 0 && Math.abs(nums[left]) == nums[right]) return nums[right];
            else if (Math.abs(nums[left]) > nums[right]) left++;
            else right--;
        }
        return -1;
    }
}
