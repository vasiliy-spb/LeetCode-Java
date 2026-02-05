package matrix.workingPeoplesImitation.task_3379_Transformed_Array;

// my solution
public class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i] % n;
            int index = (i + num + n) % n;
            ans[i] = nums[index];
        }
        return ans;
    }
}
