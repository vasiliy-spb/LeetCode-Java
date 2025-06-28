package matrix.workingPeoplesImitation.task_2653_Sliding_Subarray_Beauty;

import java.util.TreeMap;

// my solution
public class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] prefixCountNegative = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixCountNegative[i + 1] = prefixCountNegative[i] + (nums[i] < 0 ? 1 : 0);
        }
        int[] ans = new int[n - k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        for (int i = k; i < n; i++) {
            if (prefixCountNegative[i] - prefixCountNegative[i - k] < x) {
                ans[i - k] = 0;
            } else {
                int a = x;
                for (int num : map.keySet()) {
                    a -= map.get(num);
                    if (a <= 0) {
                        ans[i - k] = num;
                        break;
                    }
                }
            }
            map.merge(nums[i - k], -1, Integer::sum);
            if (map.get(nums[i - k]) == 0) {
                map.remove(nums[i - k]);
            }
            map.merge(nums[i], 1, Integer::sum);
        }
        if (prefixCountNegative[n] - prefixCountNegative[n - k] < x) {
            ans[n - k] = 0;
        } else {
            int a = x;
            for (int num : map.keySet()) {
                a -= map.get(num);
                if (a <= 0) {
                    ans[n - k] = num;
                    break;
                }
            }
        }
        return ans;
    }
}
