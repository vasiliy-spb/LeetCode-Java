package matrix.workingPeoplesImitation.task_3741_Minimum_Distance_Between_Three_Equal_Elements_II;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// from leetcode editorial (Approach: Traversal + Hash Table)
public class Solution2 {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        Arrays.fill(next, -1);
        Map<Integer, Integer> occur = new HashMap<>();
        int ans = n + 1;

        for (int i = n - 1; i >= 0; i--) {
            if (occur.containsKey(nums[i])) {
                next[i] = occur.get(nums[i]);
            }
            occur.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int secondPos = next[i];
            if (secondPos != -1) {
                int thirdPos = next[secondPos];
                if (thirdPos != -1) {
                    ans = Math.min(ans, thirdPos - i);
                }
            }
        }

        return ans == n + 1 ? -1 : ans * 2;
    }
}
