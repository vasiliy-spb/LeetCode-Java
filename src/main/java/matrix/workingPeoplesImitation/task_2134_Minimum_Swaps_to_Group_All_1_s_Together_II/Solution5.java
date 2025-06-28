package matrix.workingPeoplesImitation.task_2134_Minimum_Swaps_to_Group_All_1_s_Together_II;

// from leetcode solutions (https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/solutions/5572247/on-sliding-window-2-ms-beats-100-java-c-python-rust-go-javascript/)
public class Solution5 {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOnes = 0;

        // Count total number of 1's and create a doubled array
        int[] doubledNums = new int[2 * n];
        for (int i = 0; i < n; i++) {
            totalOnes += nums[i];
            doubledNums[i] = doubledNums[i + n] = nums[i];
        }

        // Edge cases
        if (totalOnes == 0 || totalOnes == n) return 0;

        // Create cumulative sum array
        int[] cumulativeSum = new int[2 * n + 1];
        for (int i = 0; i < 2 * n; i++) {
            cumulativeSum[i + 1] = cumulativeSum[i] + doubledNums[i];
        }

        int maxOnesInWindow = 0;

        // Check all possible windows of size totalOnes
        for (int i = 0; i <= n; i++) {
            int onesInWindow = cumulativeSum[i + totalOnes] - cumulativeSum[i];
            maxOnesInWindow = Math.max(maxOnesInWindow, onesInWindow);
        }

        return totalOnes - maxOnesInWindow;
    }
}
