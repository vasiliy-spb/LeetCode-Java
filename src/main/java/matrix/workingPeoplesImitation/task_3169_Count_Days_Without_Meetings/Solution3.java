package matrix.workingPeoplesImitation.task_3169_Count_Days_Without_Meetings;

import java.util.Arrays;
import java.util.Comparator;

// from leetcode editorial (Approach 2: Sorting)
public class Solution3 {
    public int countDays(int days, int[][] meetings) {
        int freeDays = 0, latestEnd = 0;

        // Sort meetings based on starting times
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            // Add current range of days without a meeting
            if (start > latestEnd + 1) {
                freeDays += start - latestEnd - 1;
            }

            // Update latest meeting end
            latestEnd = Math.max(latestEnd, end);
        }

        // Add all days after the last day of meetings
        freeDays += days - latestEnd;

        return freeDays;
    }
}
