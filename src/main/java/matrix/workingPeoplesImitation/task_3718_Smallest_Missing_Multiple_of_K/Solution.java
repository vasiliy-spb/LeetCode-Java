package matrix.workingPeoplesImitation.task_3718_Smallest_Missing_Multiple_of_K;

import java.util.HashSet;
import java.util.Set;

// my solution
public class Solution {
    public int missingMultiple(int[] nums, int k) {
        int initialK = k;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % k == 0) {
                set.add(nums[i]);
            }
        }
        while (set.contains(k)) {
            k += initialK;
        }
        return k;
    }
}
