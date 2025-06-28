package matrix.workingPeoplesImitation.task_3255_Find_the_Power_of_K_Size_Subarrays_II;

// from leetcode code sample (1)
public class Solution3 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;

        int[] prefix = new int[n];
        for (int i = 1; i < n; ++i) {
            prefix[i] = prefix[i - 1];
            if (nums[i] == nums[i - 1] + 1) {
                ++prefix[i];
            }
        }

        int[] result = new int[n - k + 1];
        for (int i = 0, j = k - 1; j < n; ++i, ++j) {
            if (prefix[j] - prefix[i] == k - 1) {
                result[i] = nums[j];
            } else {
                result[i] = -1;
            }
        }

        return result;
    }
}
