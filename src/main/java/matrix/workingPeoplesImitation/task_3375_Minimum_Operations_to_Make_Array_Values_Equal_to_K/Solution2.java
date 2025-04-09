package matrix.workingPeoplesImitation.task_3375_Minimum_Operations_to_Make_Array_Values_Equal_to_K;

import java.util.HashSet;
import java.util.Set;

// from leetcode editorial (Approach 1: Hash map)
public class Solution2 {
    public int minOperations(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();
        for (int x : nums) {
            if (x < k) {
                return -1;
            } else if (x > k) {
                st.add(x);
            }
        }
        return st.size();
    }
}
