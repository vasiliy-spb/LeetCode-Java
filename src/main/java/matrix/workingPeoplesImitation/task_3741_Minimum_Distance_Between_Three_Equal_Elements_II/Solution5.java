package matrix.workingPeoplesImitation.task_3741_Minimum_Distance_Between_Three_Equal_Elements_II;

import java.util.Arrays;

// from leetcode code sample (3)
public class Solution5 {
    public int minimumDistance(int[] nums) {
        final int[][] pos = new int[nums.length + 1][2];
        for (final int[] p : pos) {
            Arrays.fill(p, -nums.length - 1);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            final int v = nums[i];
            res = Math.min(res, i - pos[v][0]);
            pos[v][0] = pos[v][1];
            pos[v][1] = i;
        }
        return res > nums.length ? -1 : (res << 1);
    }
}
