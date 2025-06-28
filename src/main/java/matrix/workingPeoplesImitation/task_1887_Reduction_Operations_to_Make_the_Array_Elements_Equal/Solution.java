package matrix.workingPeoplesImitation.task_1887_Reduction_Operations_to_Make_the_Array_Elements_Equal;

import java.util.Arrays;

// my solution
public class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        int count = 0;
        int add = 0;
        for (int i = 0; i < nums.length; i++) {
            if (prev != nums[i]) {
                add++;
            }
            count += add;
            prev = nums[i];
        }
        return count;
    }
}
