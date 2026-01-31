package matrix.workingPeoplesImitation.task_2148_Count_Elements_With_Strictly_Smaller_and_Greater_Elements;

import java.util.Arrays;

// from walkccc.me
public class Solution2 {
    public int countElements(int[] nums) {
        final int mn = Arrays.stream(nums).min().getAsInt();
        final int mx = Arrays.stream(nums).max().getAsInt();
        return (int) Arrays.stream(nums).filter(num -> mn < num && num < mx).count();
    }
}
