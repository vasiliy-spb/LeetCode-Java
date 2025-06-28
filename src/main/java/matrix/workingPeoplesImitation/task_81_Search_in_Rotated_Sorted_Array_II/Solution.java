package matrix.workingPeoplesImitation.task_81_Search_in_Rotated_Sorted_Array_II;

public class Solution {

    // my solution
    public boolean search(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target;
        int start = 0;
        int end = nums.length - 1;
        if (nums[start] == nums[end]) {
            while (start < end && nums[start] == nums[0])
                start++;
            while (start < end && nums[end] == nums[nums.length - 1])
                end--;
        }
        if (end < nums.length - 1) end++;
        int pivotIndex = nums[0] > nums[1] ? 1 : findPivotIndex(nums, start, end);
        int index = binarySearchNum(nums, target, start, pivotIndex - 1);
        if (nums[index] == target) return true;
        index = binarySearchNum(nums, target, pivotIndex, nums.length - 1);
        return nums[index] == target;
    }

    private int binarySearchNum(int[] nums, int target, int left, int right) {
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) return middle;
            if (nums[middle] > target) right = middle;
            else left = middle + 1;
        }
        return left;
    }

    private int findPivotIndex(int[] nums, int left, int right) {
        while (left < right) {
            int middle = (left + right) / 2;
            if (middle > 0 && nums[middle] < nums[middle - 1]) return middle;
            if (nums[middle] > nums[nums.length - 1]) left = middle + 1;
            else right = middle;
        }
        return left;
    }

    // from walkccc.me
    public boolean search2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            final int m = (l + r) / 2;
            if (nums[m] == target)
                return true;
            if (nums[l] == nums[m] && nums[m] == nums[r]) {
                ++l;
                --r;
            } else if (nums[l] <= nums[m]) { // nums[l..m] are sorted
                if (nums[l] <= target && target < nums[m])
                    r = m - 1;
                else
                    l = m + 1;
            } else { // nums[m..n - 1] are sorted
                if (nums[m] < target && target <= nums[r])
                    l = m + 1;
                else
                    r = m - 1;
            }
        }

        return false;
    }
}
