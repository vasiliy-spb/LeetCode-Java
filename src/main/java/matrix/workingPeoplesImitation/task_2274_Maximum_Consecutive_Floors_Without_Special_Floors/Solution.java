package matrix.workingPeoplesImitation.task_2274_Maximum_Consecutive_Floors_Without_Special_Floors;

import java.util.Arrays;

public class Solution {

    // my solution
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int count = special[0] - bottom;
        for (int i = 1; i < special.length; i++) {
            count = Math.max(count, Math.abs(special[i] - special[i - 1]) - 1);
        }
        count = Math.max(count, Math.abs(top - special[special.length - 1]));
        return count;
    }

    // from walkccc.me
    public int maxConsecutive2(int bottom, int top, int[] special) {
        int ans = 0;

        Arrays.sort(special);

        for (int i = 1; i < special.length; ++i)
            ans = Math.max(ans, special[i] - special[i - 1] - 1);

        return Math.max(ans, Math.max(special[0] - bottom, top - special[special.length - 1]));
    }
}
