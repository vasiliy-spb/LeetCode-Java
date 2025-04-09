package matrix.workingPeoplesImitation.task_2233_Maximum_Product_After_K_Increments;

import java.util.Arrays;

// from leetcode code sample (3)
public class Solution5 {
    public int maximumProduct(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] presum = new long[n];
        for (int i = 0; i < n; i++)
            presum[i] = (i == 0 ? 0 : presum[i - 1]) + nums[i];
        long[] diff = new long[n];
        for (int i = 0; i < n; i++)
            diff[i] = (long) nums[i] * (i + 1) - presum[i];

        int p = binarySearch(diff, k);
        long total = presum[p] + k;
        int each = (int) (total / (p + 1));
        int extra = (int) (total % (p + 1));
        long ret = 1;
        int M = (int) 1e9 + 7;
        for (int i = 0; i < extra; i++)
            ret = ret * (each + 1) % M;
        for (int i = extra; i < p + 1; i++)
            ret = ret * each % M;
        for (int i = p + 1; i < n; i++)
            ret = ret * nums[i] % M;
        return (int) ret;
    }

    public int binarySearch(long[] diff, int k) {
        int l = 0;
        int r = diff.length - 1;
        while (l < r) {
            int mid = (l + r) / 2 + 1;
            if (diff[mid] <= k)
                l = mid;
            else
                r = mid - 1;
        }
        return l;
    }
}
