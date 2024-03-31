package matrix.workingPeoplesImitation.task_153_Find_Minimum_in_Rotated_Sorted_Array;

public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums[0] < nums[nums.length - 1]) return nums[0];
        int index = searchPivotIndex(nums);
        return nums[index + 1];
    }

    private int searchPivotIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (middle < nums.length - 1 && nums[middle] > nums[middle + 1]) return middle;
            if (nums[middle] > nums[nums.length - 1]) left = middle + 1;
            else right = middle;
        }
        return left;
    }
}
