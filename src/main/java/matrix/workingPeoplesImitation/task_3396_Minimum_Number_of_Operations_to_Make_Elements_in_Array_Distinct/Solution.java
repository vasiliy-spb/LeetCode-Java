package matrix.workingPeoplesImitation.task_3396_Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct;

import java.util.HashSet;
import java.util.Set;

// my solution
public class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (set.contains(nums[i])) {
                return (i + 1) / 3 + (((i + 1) % 3 == 0) ? 0 : 1);
            }
            set.add(nums[i]);
        }
        return 0;
    }
}
