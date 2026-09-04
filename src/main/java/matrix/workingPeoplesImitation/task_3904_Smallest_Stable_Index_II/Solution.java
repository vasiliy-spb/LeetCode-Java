package matrix.workingPeoplesImitation.task_3904_Smallest_Stable_Index_II;

// my solution
public class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suffixMin = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            suffixMin[i] = nums[i];
            if (i < n - 1 && suffixMin[i] > suffixMin[i + 1]) {
                suffixMin[i] = suffixMin[i + 1];
            }
        }
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (max - suffixMin[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}
