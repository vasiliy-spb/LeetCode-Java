package matrix.workingPeoplesImitation.task_3255_Find_the_Power_of_K_Size_Subarrays_II;

// from leetcode code sample (2)
public class Solution4 {
    public int[] resultsArray(int[] nums, int k) {
        int max = Integer.MAX_VALUE - 1;
        int len = 0;
        for(int i = 0; i < k; i++) {
            if(nums[i] != max + 1) {
                len = 1;
                max = nums[i];
            } else {
                len++;
                max++;
            }
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = len == k ? max : -1;
        for(int i = 1; i < ans.length; i++) {
            if(nums[i + k - 1] != max + 1) {
                len = 1;
            } else {
                len++;
            }
            max = nums[i + k - 1];
            ans[i] = len >= k ? max : -1;
        }
        return ans;
    }
}
