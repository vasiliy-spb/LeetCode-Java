package matrix.workingPeoplesImitation.task_2873_Maximum_Value_of_an_Ordered_Triplet_I;

// my solution
public class Solution {
    public long maximumTripletValue(int[] nums) {
        long max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < 0 && nums[j] < 0 && nums[k] < 0) {
                        continue;
                    }
                    max = Math.max(max, (long) (nums[i] - nums[j]) * nums[k]);
                }
            }
        }
        return max;
    }
}
