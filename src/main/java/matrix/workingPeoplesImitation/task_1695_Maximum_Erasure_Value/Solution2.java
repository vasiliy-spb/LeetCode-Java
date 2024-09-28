package matrix.workingPeoplesImitation.task_1695_Maximum_Erasure_Value;

import java.util.HashSet;
import java.util.Set;

// from walkccc.me
public class Solution2 {
    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0;
        int score = 0;
        Set<Integer> seen = new HashSet<>();

        for (int l = 0, r = 0; r < nums.length; ++r) {
            while (!seen.add(nums[r])) {
                score -= nums[l];
                seen.remove(nums[l++]);
            }
            score += nums[r];
            ans = Math.max(ans, score);
        }

        return ans;
    }
}
