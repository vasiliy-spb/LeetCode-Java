package matrix.workingPeoplesImitation.task_35_Search_Insert_Position;

public class Solution {
    // my solution
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) return middle;
            if (nums[middle] < target) left = middle + 1;
            else right = middle;
        }
        return nums[left] < target ? left + 1 : left;
    }

    // from walkccc.me
    public int searchInsert2(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            final int m = (l + r) / 2;
            if (nums[m] == target)
                return m;
            if (nums[m] < target)
                l = m + 1;
            else
                r = m;
        }

        return l;
    }

}
