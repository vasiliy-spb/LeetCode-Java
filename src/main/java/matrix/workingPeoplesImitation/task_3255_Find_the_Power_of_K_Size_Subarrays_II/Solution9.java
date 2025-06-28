package matrix.workingPeoplesImitation.task_3255_Find_the_Power_of_K_Size_Subarrays_II;

// from leetcode code sample (7)
public class Solution9 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int arr[] = new int[n];
        arr[0] = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                arr[i] = 1;
            }
        }
        int res[] = new int[n - k + 1];
        int cnt = 0;
        for (int i = 1; i < k; i++) {
            cnt += arr[i];
        }
        res[0] = (cnt > 0) ? -1 : nums[k - 1];
        for (int i = k; i < n; i++) {
            cnt += arr[i];
            cnt -= arr[i - k + 1];
            res[i - k + 1] = (cnt > 0) ? -1 : nums[i];
        }
        return res;
    }
}
