package matrix.workingPeoplesImitation.task_3379_Transformed_Array;

// from walkccc.me
public class Solution3 {
    public int[] constructTransformedArray(int[] nums) {
        final int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; ++i) {
            ans[i] = nums[(i + nums[i] % n + n) % n];
        }

        return ans;
    }
}
