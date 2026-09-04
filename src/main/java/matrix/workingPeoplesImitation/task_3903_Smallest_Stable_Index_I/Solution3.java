package matrix.workingPeoplesImitation.task_3903_Smallest_Stable_Index_I;

// from leetcode code sample (1)
public class Solution3 {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i]);
        }
        int left = 0;
        for (int i = 0; i < n; i++) {
            left = Math.max(left, nums[i]);
            if (left - right[i] <= k) {
                return i;
            }
        }
        return -1;
    }

}
