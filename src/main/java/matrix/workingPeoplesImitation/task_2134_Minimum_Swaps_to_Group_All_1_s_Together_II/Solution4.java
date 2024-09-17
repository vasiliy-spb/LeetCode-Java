package matrix.workingPeoplesImitation.task_2134_Minimum_Swaps_to_Group_All_1_s_Together_II;

// from leetcode editorial (Approach 3: Cleaner and More Intuitive Sliding Window)
public class Solution4 {
    public int minSwaps(int[] nums) {
        // Initialize minimum swaps to a large value
        int minimumSwaps = Integer.MAX_VALUE;

        // Calculate the total number of 1s in the array
        int totalOnes = 0;
        for (int num : nums) {
            totalOnes += num;
        }

        // Initialize the count of 1s in the current window
        int onesCount = nums[0];
        int end = 0;

        // Slide the window across the array
        for (int start = 0; start < nums.length; ++start) {
            // Adjust onesCount by removing the element that is sliding out of
            // the window
            if (start != 0) {
                onesCount -= nums[start - 1];
            }

            // Expand the window to the right until it reaches the desired size
            while (end - start + 1 < totalOnes) {
                end++;
                onesCount += nums[end % nums.length];
            }

            // Update the minimum number of swaps needed
            minimumSwaps = Math.min(minimumSwaps, totalOnes - onesCount);
        }

        return minimumSwaps;
    }
}
