package matrix.workingPeoplesImitation.task_1508_Range_Sum_of_Sorted_Subarray_Sums;

import java.util.Arrays;

// from walkccc.me (rewrote by deepseek)
public class Solution5 {
    private static final int MOD = 1_000_000_007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        int L = Arrays.stream(nums).min().getAsInt();
        int R = Arrays.stream(nums).sum();

        long sumRight = firstKSubarraysSum(nums, right, L, R);
        long sumLeft = firstKSubarraysSum(nums, left - 1, L, R);
        return (int) ((sumRight - sumLeft) % MOD);
    }

    private long firstKSubarraysSum(int[] nums, int k, int L, int R) {
        int l = L;
        int r = R;

        while (l < r) {
            int m = l + (r - l) / 2;
            Pair pair = subarraysAndSumNoGreaterThan(nums, m);
            if (pair.count < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        Pair pair = subarraysAndSumNoGreaterThan(nums, l);
        return pair.total - (long) l * (pair.count - k);
    }

    private Pair subarraysAndSumNoGreaterThan(int[] nums, int m) {
        int count = 0;
        long total = 0;
        int sum = 0;
        int window = 0;

        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j] * (j - i + 1);
            window += nums[j];
            while (window > m) {
                sum -= window;
                window -= nums[i++];
            }
            count += j - i + 1;
            total += sum;
        }

        return new Pair(count, total);
    }

    private static class Pair {
        int count;
        long total;

        Pair(int count, long total) {
            this.count = count;
            this.total = total;
        }
    }
}
