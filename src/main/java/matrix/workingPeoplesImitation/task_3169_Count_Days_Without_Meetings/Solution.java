package matrix.workingPeoplesImitation.task_3169_Count_Days_Without_Meetings;

import java.util.Arrays;

// my solution
public class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (m1, m2) -> Integer.compare(m1[0], m2[0]));
        int ans = 0;
        int prev = 1;
        if (meetings[0][0] > 1) {
            ans += meetings[0][0] - 1;
            prev = meetings[0][1];
        }
        for (int[] meeting : meetings) {
            if (meeting[0] > prev) {
                ans += meeting[0] - prev - 1;
            }
            prev = Math.max(prev, meeting[1]);
        }
        if (days > prev) {
            ans += days - prev;
        }
        return ans;
    }
}
