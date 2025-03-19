package matrix.workingPeoplesImitation.task_3191_Minimum_Operations_to_Make_Binary_Array_Elements_Equal_to_One_I;

import java.util.Arrays;

// my solution
public class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i <= n - 3; i++) {
            if (shouldBeFlipped(nums[i])) {
                flipThreeElements(nums, i);
                count++;
            }
        }
        return isFilledByOnes(nums) ? count : -1;
    }

    private static boolean shouldBeFlipped(int num) {
        return num == 0;
    }

    private static void flipThreeElements(int[] nums, int i) {
        for (int j = i; j <= i + 2; j++) {
            nums[j] ^= 1;
        }
    }

    private static boolean isFilledByOnes(int[] nums) {
        return Arrays.stream(nums).sum() == nums.length;
    }
}
