package matrix.workingPeoplesImitation.task_33_Search_in_Rotated_Sorted_Array;

public class Solution {
    public int search(int[] nums, int target) {
        int indexZero;
        if (nums[0] != 0) indexZero = searchBreakIndex(nums);
        else indexZero = 0;
        int index = searchTargetIndex(nums, target, 0, indexZero);
        if (index >= 0) return index;
        return searchTargetIndex(nums, target, indexZero + 1, nums.length - 1);
    }

    private int searchBreakIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (middle < nums.length - 1 && nums[middle] > nums[middle + 1]) return middle;
            if (nums[middle] > nums[nums.length - 1]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return -1;
    }
    private int searchTargetIndex(int[] nums, int target, int fromIndex, int toIndex) {
        int left = Math.max(fromIndex, 0);
        int right = toIndex;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) return middle;
            if (nums[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        if (nums[left] == target) return left;
        return -1;
    }
}
