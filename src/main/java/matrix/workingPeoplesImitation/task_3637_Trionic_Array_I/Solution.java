package matrix.workingPeoplesImitation.task_3637_Trionic_Array_I;

// my solution
public class Solution {
    public boolean isTrionic(int[] nums) {
        int turnCount = 0;
        boolean increase = nums[0] < nums[1];
        if (!increase) {
            return false;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return false;
            }
            boolean currentIncrease = nums[i - 1] < nums[i];
            if (increase && !currentIncrease || !increase && currentIncrease) {
                turnCount++;
            }
            increase = currentIncrease;
        }
        return turnCount == 2;
    }
}
