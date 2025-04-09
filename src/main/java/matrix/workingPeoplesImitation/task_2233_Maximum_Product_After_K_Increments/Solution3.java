package matrix.workingPeoplesImitation.task_2233_Maximum_Product_After_K_Increments;

// from leetcode code sample (1)
public class Solution3 {
    /**
     * SOLUTION: Maximum Product After K Increments
     * <p>
     * Approach: Binary Search on Minimum Value
     * Steps:
     * 1. Binary search for the minimum value after applying increments
     * 2. Check if K increments are sufficient to reach given minimum
     * 3. Calculate the final product with remaining increments optimally distributed
     * <p>
     * Time Complexity: O(n log M) where n is array length, M is search space
     * Space Complexity: O(1) constant extra space
     * <p>
     * INTERVIEW SUITABILITY: Not recommended for mid-level Java interview
     * - Implementation is complex and difficult to understand
     * - Binary search approach is advanced but not clearly executed
     * - Variable naming and logic could be improved for clarity
     */
    public int maximumProduct(int[] nums, int k) {
        int left = 0;
        int right = 2000001;
        int mid = left + (right - left + 1) / 2;

        // Binary search to find the minimum value after increments
        while (right > left) {
            if (extraK(nums, k, mid) >= 0) {  // Valid guess
                left = mid;
            } else {
                right = mid - 1;
            }
            mid = left + (right - left + 1) / 2;
        }

        int minVal = left;
        int extra = extraK(nums, k, mid);
        long ans = 1;

        // Calculate the product with the determined minimum value
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= minVal) {
                if (extra > 0) {
                    extra--;
                    ans *= minVal + 1;
                } else {
                    ans *= minVal;
                }
            } else {
                ans *= nums[i];
            }
            ans %= 1000000007L;
        }

        return (int) ans;
    }

    // Helper method to check if k increments are enough to reach the guessed minimum
    public int extraK(int[] nums, int k, int guess) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < guess) {
                k -= guess - nums[i];
            }
            if (k < 0) {
                return -1;
            }
        }
        return k;
    }
}
