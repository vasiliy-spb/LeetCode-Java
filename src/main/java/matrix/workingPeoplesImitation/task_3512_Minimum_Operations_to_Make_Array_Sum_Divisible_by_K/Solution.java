package matrix.workingPeoplesImitation.task_3512_Minimum_Operations_to_Make_Array_Sum_Divisible_by_K;

import java.util.Arrays;

// my solution
public class Solution {
    public int minOperations(int[] nums, int k) {
        return Arrays.stream(nums).sum() % k;
    }
}
