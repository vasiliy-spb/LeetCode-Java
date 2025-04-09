package matrix.workingPeoplesImitation.task_2233_Maximum_Product_After_K_Increments;

import java.util.Arrays;

// from leetcode code sample (4)
public class Solution6 {
    public int maximumProduct(int[] nums, int k) {
        int l = 0, h = 2000000;
        while (l <= h) {
            int mid = (l + h) / 2;
            long total = 0;
            for (int a : nums) {
                total += Math.max(0, mid - a);
            }
            if (total <= k) l = mid + 1;
            else h = mid - 1;
        }
        for (int i = 0; i < nums.length; i++) {
            k -= Math.max(0, h - nums[i]);
            nums[i] = Math.max(nums[i], h);
        }
        long prod = 1;
        int mod = 1000000007;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (k-- > 0) nums[i]++;
            prod = (prod * nums[i]) % mod;
        }
        return (int) prod;
    }
}
