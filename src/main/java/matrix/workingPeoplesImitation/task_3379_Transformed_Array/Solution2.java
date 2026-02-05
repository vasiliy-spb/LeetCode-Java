package matrix.workingPeoplesImitation.task_3379_Transformed_Array;

// from leetcode editorial (Approach: Traversal)
public class Solution2 {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[(((i + nums[i]) % n) + n) % n];
        }
        return res;
    }
}
