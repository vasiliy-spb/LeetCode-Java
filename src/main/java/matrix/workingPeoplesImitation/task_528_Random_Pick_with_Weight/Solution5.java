package matrix.workingPeoplesImitation.task_528_Random_Pick_with_Weight;

import java.util.Random;

// from leetcode code sample (3)
public class Solution5 {
    private int[] prefixSums; // stores the prefix sums of the weights
    private Random random = new Random(); // random number generator

    public Solution5(int[] weights) {
        int n = weights.length;
        prefixSums = new int[n + 1];
        // Generate prefix sums array where each element represents the sum of weights up to that index.
        for (int i = 0; i < n; ++i) {
            prefixSums[i + 1] = prefixSums[i] + weights[i];
        }
    }

    public int pickIndex() {
        // Generate a random number between 1 and the total sum of weights.
        int x = 1 + random.nextInt(prefixSums[prefixSums.length - 1]);
        int left = 1, right = prefixSums.length - 1;

        // Perform binary search to find the index for which prefixSums[index] is greater than or equal to x.
        while (left < right) {
            int mid = (left + right) >>> 1; // Use unsigned right shift to avoid potential overflow
            if (prefixSums[mid] >= x) {
                // If the mid-index satisfies the condition, we search the left subarray.
                right = mid;
            } else {
                // Otherwise, we search the right subarray.
                left = mid + 1;
            }
        }
        // Since we have shifted our prefixSums array by one, we subtract one to get the original index.
        return left - 1;
    }
}
