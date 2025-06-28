package matrix.workingPeoplesImitation.task_260_Single_Number_III;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    // my solution
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums)
            if (set.contains(i)) set.remove(i);
            else set.add(i);
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    // from walkccc.me
    public int[] singleNumber2(int[] nums) {
        final int xors = Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
        final int lowbit = xors & -xors;
        int[] ans = new int[2];

        // Seperate `nums` into two groups by `lowbit`.
        for (final int num : nums)
            if ((num & lowbit) > 0)
                ans[0] ^= num;
            else
                ans[1] ^= num;

        return ans;
    }

}
