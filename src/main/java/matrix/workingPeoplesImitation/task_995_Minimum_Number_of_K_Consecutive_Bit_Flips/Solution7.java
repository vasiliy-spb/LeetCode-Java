package matrix.workingPeoplesImitation.task_995_Minimum_Number_of_K_Consecutive_Bit_Flips;

// from leetcode code sample (2)
public class Solution7 {
    //slidding window
    //tc -> O(N) → Efficient sliding window approach
    //sc -> O(1) → In-place modification
    public int minKBitFlips(int[] nums, int k) {
        int flipCount = 0; // Tracks the current number of ongoing flips
        int result = 0;    // Tracks the total number of flips performed

        for (int i = 0; i < nums.length; i++) {
            // If the current index is outside the range of the last flip window,
            // adjust flipCount by removing the effect of previous flips
            if (i >= k && nums[i - k] == -1) {
                flipCount--;
            }

            // If the current bit needs to be flipped to become 1
            // Condition: flipCount % 2 determines the effective bit value
            if (flipCount % 2 == nums[i]) {
                // If flipping is not possible because the remaining elements are less than k
                if (i + k > nums.length) {
                    return -1;
                }

                // Mark the current position as flipped using -1 (to track past flips)
                nums[i] = -1;

                // Increase the flip count
                flipCount++;

                // Increase the total flip count
                result++;
            }
        }

        return result;
    }
}
