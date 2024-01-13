package matrix.workingPeoplesImitation.task_283_Move_Zeroes;

public class Solution {
    public void moveZeroes(int[] nums) {
        int moveIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (nums[i] != nums[moveIndex]) {
                    nums[moveIndex++] = nums[i];
                } else {
                    moveIndex++;
                }
            }
        }
        while (moveIndex < nums.length) {
            if (nums[moveIndex] != 0) {
                nums[moveIndex++] = 0;
            } else {
                moveIndex++;
            }
        }
    }
}
