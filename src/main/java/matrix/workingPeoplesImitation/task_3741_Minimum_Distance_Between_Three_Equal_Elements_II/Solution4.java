package matrix.workingPeoplesImitation.task_3741_Minimum_Distance_Between_Three_Equal_Elements_II;

// from leetcode code sample (2)
public class Solution4 {
    public int minimumDistance(int[] nums) {
        int[][] id = new int[2][nums.length + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            id[0][i] = -1;
            id[1][i] = -1;
        }
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (id[0][nums[i]] != -1 && id[1][nums[i]] != -1) {
                int cur = i - id[0][nums[i]] + i - id[1][nums[i]] + id[1][nums[i]] - id[0][nums[i]];
                if (res == -1) {
                    res = cur;
                } else {
                    res = Math.min(res, cur);
                }
                id[0][nums[i]] = id[1][nums[i]];
                id[1][nums[i]] = i;

            } else if (id[0][nums[i]] == -1) {
                id[0][nums[i]] = i;
            } else if (id[1][nums[i]] == -1) {
                id[1][nums[i]] = i;
            }
        }
        return res;
    }
}
