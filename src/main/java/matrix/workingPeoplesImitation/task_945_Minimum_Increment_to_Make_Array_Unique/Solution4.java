package matrix.workingPeoplesImitation.task_945_Minimum_Increment_to_Make_Array_Unique;

import java.util.Arrays;

// from walkccc.me
public class Solution4 {
    public int minIncrementForUnique(int[] nums) {
        int ans = 0;
        int minAvailable = 0;

        Arrays.sort(nums);

        for (final int num : nums) {
            ans += Math.max(minAvailable - num, 0);
            minAvailable = Math.max(minAvailable, num) + 1;
        }

        return ans;
    }
}
