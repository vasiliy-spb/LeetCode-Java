package matrix.workingPeoplesImitation.task_961_N_Repeated_Element_in_Size_2N_Array;

import java.util.Arrays;

// my solution
public class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length / 2;
        for (int i = 0; i <= n; i++) {
            if (nums[i] == nums[i + n - 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
