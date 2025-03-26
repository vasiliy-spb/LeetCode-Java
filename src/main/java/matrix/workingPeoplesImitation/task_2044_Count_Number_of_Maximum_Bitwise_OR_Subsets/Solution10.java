package matrix.workingPeoplesImitation.task_2044_Count_Number_of_Maximum_Bitwise_OR_Subsets;

import java.util.Arrays;

// from walkccc.me
public class Solution10 {
    public int countMaxOrSubsets(int[] nums) {
        final int ors = Arrays.stream(nums).reduce((a, b) -> a | b).getAsInt();
        dfs(nums, 0, 0, ors);
        return ans;
    }

    private int ans = 0;

    private void dfs(int[] nums, int i, int path, final int ors) {
        if (i == nums.length) {
            if (path == ors)
                ++ans;
            return;
        }

        dfs(nums, i + 1, path, ors);
        dfs(nums, i + 1, path | nums[i], ors);
    }
}
