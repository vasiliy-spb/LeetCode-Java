package matrix.workingPeoplesImitation.task_3718_Smallest_Missing_Multiple_of_K;

import java.util.HashSet;
import java.util.Set;

// from leetcode editorial (Approach: Enumeration + Hash Table)
public class Solution2 {

    public int missingMultiple(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }
        int ans = k;
        while (seen.contains(ans)) {
            ans += k;
        }
        return ans;
    }
}
