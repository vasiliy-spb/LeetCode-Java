package matrix.workingPeoplesImitation.task_643_Maximum_Average_Subarray_I;

public class Solution {

    // my solution
    public double findMaxAverage(int[] nums, int k) {
        double result = -1e4 + 1;
        int sum = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i < k - 1) continue;
            if (i >= k) sum -= nums[j++];
            result = Math.max(result, (double) sum / k);
        }
        return result;
    }

    // from walkccc.me
    public double findMaxAverage3(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; ++i)
            sum += nums[i];
        double ans = sum;

        for (int i = k; i < nums.length; ++i) {
            sum += nums[i] - nums[i - k];
            ans = Math.max(ans, sum);
        }

        return ans / k;
    }
}
