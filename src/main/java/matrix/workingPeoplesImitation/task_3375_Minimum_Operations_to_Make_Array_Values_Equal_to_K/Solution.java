package matrix.workingPeoplesImitation.task_3375_Minimum_Operations_to_Make_Array_Values_Equal_to_K;

import java.util.HashSet;
import java.util.Set;

// my solution
public class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < k) {
                return -1;
            }
            if (num != k) {
                set.add(num);
            }
        }
        return set.size();
    }
}
