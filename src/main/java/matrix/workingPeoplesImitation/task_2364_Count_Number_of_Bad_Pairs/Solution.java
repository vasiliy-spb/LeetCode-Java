package matrix.workingPeoplesImitation.task_2364_Count_Number_of_Bad_Pairs;

import java.util.*;

// my solution
public class Solution {
    // after hint
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> diffMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            diffMap.merge(nums[i] - i, 1, Integer::sum);
        }
        long ans = (long) n * (n - 1) / 2;
        for (int value : diffMap.values()) {
            ans -= (long) value * (value - 1) / 2;
        }
        return ans;
    }
}
