package matrix.workingPeoplesImitation.task_3169_Count_Days_Without_Meetings;

import java.util.Arrays;

// from walkccc.me
public class Solution4 {
    public int countDays(int days, int[][] meetings) {
        int freeDays = 0;
        int prevEnd = 0;

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] meeting : meetings) {
            final int start = meeting[0];
            final int end = meeting[1];
            if (start > prevEnd)
                freeDays += start - prevEnd - 1;
            prevEnd = Math.max(prevEnd, end);
        }

        return freeDays + Math.max(0, days - prevEnd);
    }
}
