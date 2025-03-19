package matrix.workingPeoplesImitation.task_2206_Divide_Array_Into_Equal_Pairs;

import java.util.Arrays;

// from walkccc.me
public class Solution6 {
    public boolean divideArray(int[] nums) {
        int[] count = new int[501];

        for (final int num : nums)
            ++count[num];

        return Arrays.stream(count).allMatch(c -> c % 2 == 0);
    }
}
