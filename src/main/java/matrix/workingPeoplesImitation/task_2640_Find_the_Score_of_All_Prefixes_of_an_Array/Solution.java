package matrix.workingPeoplesImitation.task_2640_Find_the_Score_of_All_Prefixes_of_an_Array;

// my solution
public class Solution {
    public long[] findPrefixScore0(int[] nums) {
        int n = nums.length;
        int[] max = new int[n + 1];
        for (int i = 0; i < n; i++) {
            max[i + 1] = Math.max(nums[i], max[i]);
        }
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            ans[i] = max[i + 1] + nums[i];
            if (i > 0) {
                ans[i] += ans[i - 1];
            }
        }
        return ans;
    }
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            ans[i] = max + nums[i];
            if (i > 0) {
                ans[i] += ans[i - 1];
            }
        }
        return ans;
    }
}
