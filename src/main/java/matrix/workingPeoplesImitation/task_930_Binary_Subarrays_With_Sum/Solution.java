package matrix.workingPeoplesImitation.task_930_Binary_Subarrays_With_Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            if (sum == goal) count++;
            if (sumMap.containsKey(sum - goal)) count += sumMap.get(sum - goal);
            sumMap.merge(sum, 1, Integer::sum);
        }
        return count;
    }


    // my solution (WA)
    public int numSubarraysWithSum1(int[] nums, int goal) {
        System.out.println("nums = " + Arrays.toString(nums));
        int n = nums.length;
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            prefixSum[i] += nums[i];
            if (i > 0) prefixSum[i] += prefixSum[i - 1];
        }
        System.out.println("prefixSum = " + Arrays.toString(prefixSum));
        int count = 0;
        int left = -1;
        for (int right = 0; right < n; right++) {
            if (prefixSum[right] == goal) count += right - left;
            if (left >= 0 && prefixSum[right] - prefixSum[left] > goal) {
                count -= right + 1;
                left++;
            } else if (left < 0 && prefixSum[right] > goal) {
                count -= right - left;
                left++;
            }
        }
        return count;
    }
}
