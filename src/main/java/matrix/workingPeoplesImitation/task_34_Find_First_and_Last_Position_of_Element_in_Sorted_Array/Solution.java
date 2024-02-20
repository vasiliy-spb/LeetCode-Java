package matrix.workingPeoplesImitation.task_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

public class Solution {

    // my solution
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target, true);
        int last = binarySearch(nums, target, false);
        if (first < 0 && last == nums.length) return new int[]{-1, -1};
        return new int[]{first, last};
    }
    private int binarySearch(int[] nums, int target, boolean first) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                if (first) {
                    if (mid == 0 || nums[mid - 1] != target) return mid;
                    else r = mid;
                } else {
                    if (mid == nums.length -1 || nums[mid + 1] != target) return mid;
                    else l = mid + 1;
                }
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }

    // from walkccc.me
    public int[] searchRange2(int[] nums, int target) {
        final int l = firstGreaterEqual(nums, target);
        if (l == nums.length || nums[l] != target)
            return new int[] {-1, -1};
        final int r = firstGreaterEqual(nums, target + 1) - 1;
        return new int[] {l, r};
    }

    private int firstGreaterEqual(int[] A, int target) {
        int l = 0;
        int r = A.length;
        while (l < r) {
            final int m = (l + r) / 2;
            if (A[m] >= target)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

}
