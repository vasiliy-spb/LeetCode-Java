package matrix.workingPeoplesImitation.task_995_Minimum_Number_of_K_Consecutive_Bit_Flips;

import java.util.Deque;
import java.util.LinkedList;

// from leetcode editorial (Approach 2: Using a Deque)
public class Solution3 {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length; // Length of the input array
        Deque<Integer> flipQueue = new LinkedList<>(); // Queue to keep track of flips
        int flipped = 0; // Current flip state
        int result = 0; // Total number of flips

        for (int i = 0; i < n; i++) {
            // Remove the effect of the oldest flip if it's out of the current window
            if (i >= k) {
                flipped ^= flipQueue.poll();
            }

            // If the current bit is 0 (i.e., it needs to be flipped)
            if (flipped == nums[i]) {
                // If we cannot flip a subarray starting at index i
                if (i + k > n) {
                    return -1;
                }
                // Add a flip at this position
                flipQueue.offer(1);
                flipped ^= 1; // Toggle the flipped state
                result += 1; // Increment the flip count
            } else {
                flipQueue.offer(0);
            }
        }

        return result;
    }
}
