package matrix.workingPeoplesImitation.task_3439_Reschedule_Meetings_for_Maximum_Free_I;

import java.util.function.IntUnaryOperator;

// from leetcode.doocs.org
public class Solution4 {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = endTime.length;
        IntUnaryOperator f = i -> {
            if (i == 0) {
                return startTime[0];
            }
            if (i == n) {
                return eventTime - endTime[n - 1];
            }
            return startTime[i] - endTime[i - 1];
        };
        int ans = 0, s = 0;
        for (int i = 0; i <= n; i++) {
            s += f.applyAsInt(i);
            if (i >= k) {
                ans = Math.max(ans, s);
                s -= f.applyAsInt(i - k);
            }
        }
        return ans;
    }
}
