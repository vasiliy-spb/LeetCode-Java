package matrix.workingPeoplesImitation.task_1968_Array_With_Elements_Not_Equal_to_Average_of_Neighbors;

import java.util.Arrays;

// from walkccc.me
public class Solution3 {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            final int temp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = temp;
        }
        return nums;
    }
}
