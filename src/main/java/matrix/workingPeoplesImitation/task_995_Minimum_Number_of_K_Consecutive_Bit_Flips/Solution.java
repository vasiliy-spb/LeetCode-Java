package matrix.workingPeoplesImitation.task_995_Minimum_Number_of_K_Consecutive_Bit_Flips;

import java.util.Arrays;

// my solution
public class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        if (isLikeZebra(nums) && k > 2) {
            if (k > n / 2) {
                return -1;
            } else {
                return getCountZeros(nums);
            }
        }
        int kSum = 0;
        for (int i = n - k; i < n; i++) {
            kSum += nums[i];
        }
        if (k < n / 2 && kSum < k - (nums.length - k)) {
            return -1;
        }
        int count = 0;
        for (int i = 0; i <= n - k; i++) {
            if (shouldBeFlipped(nums[i])) {
                flipKElements(nums, i, k);
                count++;
            }
        }
        return isFilledByOnes(nums) ? count : -1;
    }

    private boolean isLikeZebra(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private int getCountZeros(int[] nums) {
        return nums.length - Arrays.stream(nums).sum();
    }

    private static boolean shouldBeFlipped(int num) {
        return num == 0;
    }

    private static void flipKElements(int[] nums, int i, int k) {
        for (int j = i; j < i + k; j++) {
            nums[j] ^= 1;
        }
    }

    private static boolean isFilledByOnes(int[] nums) {
        return Arrays.stream(nums).sum() == nums.length;
    }
}
