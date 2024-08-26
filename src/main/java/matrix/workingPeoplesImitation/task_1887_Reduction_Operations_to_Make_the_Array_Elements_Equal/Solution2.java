package matrix.workingPeoplesImitation.task_1887_Reduction_Operations_to_Make_the_Array_Elements_Equal;

import java.util.Arrays;

// from leetcode editorial
public class Solution2 {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int up = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                up++;
            }

            ans += up;
        }

        return ans;
    }
}
