package matrix.workingPeoplesImitation.task_2873_Maximum_Value_of_an_Ordered_Triplet_I;

// from leetcode code sample (1)
public class Solution7 {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
        }
        long max = Long.MIN_VALUE;
        for (int j = 1; j < n - 1; j++) {
            max = Math.max(max, (long) (prefixMax[j - 1] - nums[j]) * (long) suffixMax[j + 1]);
        }
        return Math.max(max, 0);
    }
}
