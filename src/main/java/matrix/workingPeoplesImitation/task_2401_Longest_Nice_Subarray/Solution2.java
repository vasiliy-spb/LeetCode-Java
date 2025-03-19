package matrix.workingPeoplesImitation.task_2401_Longest_Nice_Subarray;

// from leetcode editorial (Approach 1: Brute Force)
public class Solution2 {
    public int longestNiceSubarray(int[] nums) {
        int maxLength = 1; // Track the maximum nice subarray length found

        for (int start = 0; start < nums.length - maxLength; start++) {
            int currentLength = 1; // Length of current nice subarray
            int usedBits = nums[start]; // Track which bits are used in our subarray

            // Try to extend the subarray
            for (int end = start + 1; end < nums.length; end++) {
                // If no bits overlap between current number and used bits, we can extend
                if ((usedBits & nums[end]) == 0) {
                    usedBits |= nums[end]; // Add new number's bits to our tracker
                    currentLength++;
                }
                // If bits overlap, this number can't be part of our nice subarray
                else break;
            }

            // Update max length if we found a longer nice subarray
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
