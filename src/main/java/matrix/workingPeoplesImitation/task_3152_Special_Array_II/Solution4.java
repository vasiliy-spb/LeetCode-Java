package matrix.workingPeoplesImitation.task_3152_Special_Array_II;

// from leetcode code sample (2)
public class Solution4 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        for (int i = nums.length - 1; i > 0; --i) {
            nums[i] = (nums[i] + nums[i - 1]) % 2;
        }
        nums[0] = 0;
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i - 1];
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            ans[i] = nums[queries[i][1]] - nums[queries[i][0]] == queries[i][1] - queries[i][0];
        }
        return ans;
    }
}
