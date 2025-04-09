package matrix.workingPeoplesImitation.task_2233_Maximum_Product_After_K_Increments;

import java.util.Arrays;

// from leetcode code sample (2)
public class Solution4 {
    public int maximumProduct(int[] nums, int k) {
        int n = nums.length, mod = 1_000_000_007;
        Arrays.sort(nums);
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int l = 0, r = n;
        while (1 < r - l) {
            int mid = l + r >> 1;
            if ((long) nums[mid] * (mid + 1) - preSum[mid + 1] <= k) {
                l = mid;
            } else {
                r = mid;
            }
        }
        k -= (int) ((long) nums[l] * (l + 1) - preSum[l + 1]);
        int incr = k / (l + 1), cnt = k % (l + 1);
        long ans = 1;
        for (int i = 0; i < n; i++) {
            int num = i <= l ? nums[l] + incr : nums[i];
            if (i < cnt) num++;
            ans = ans * num % mod;
        }
        return (int) ans;
    }
}
