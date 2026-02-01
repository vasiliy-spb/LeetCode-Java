package matrix.workingPeoplesImitation.task_3010_Divide_an_Array_Into_Subarrays_With_Minimum_Cost_I;

// my solution
public class Solution {
    public int minimumCost(int[] nums) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < firstMin) {
                secondMin = firstMin;
                firstMin = nums[i];
            } else if (nums[i] < secondMin) {
                secondMin = nums[i];
            }
        }
        return nums[0] + firstMin + secondMin;
    }
}
