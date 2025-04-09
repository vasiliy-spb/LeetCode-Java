package matrix.workingPeoplesImitation.task_3375_Minimum_Operations_to_Make_Array_Values_Equal_to_K;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

// from walkccc.me
public class Solution3 {
    public int minOperations(int[] nums, int k) {
        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        final int mn = Arrays.stream(nums).min().getAsInt();
        if (mn < k)
            return -1;
        if (mn > k)
            return numsSet.size();
        return numsSet.size() - 1;
    }
}
