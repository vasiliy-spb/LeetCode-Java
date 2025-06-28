package matrix.workingPeoplesImitation.task_3254_Find_the_Power_of_K_Size_Subarrays_I;

// my solution
public class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            boolean ascending = true;
            for (int j = i; j < i + k; j++) {
                if (j > i) {
                    ascending &= nums[j] > nums[j - 1];
                    ascending &= nums[j] - nums[j - 1] == 1;
                }
                if (!ascending) {
                    break;
                }
            }
            ans[i] = ascending ? nums[i + k - 1] : -1;
        }
        return ans;
    }
}
