package matrix.workingPeoplesImitation.task_3169_Count_Days_Without_Meetings;

import java.util.Arrays;

// from leetcode code sample (1)
public class Solution5 {
    public static int countDays(int days, int[][] meetings) {
        int[] starts = new int[meetings.length];
        int[] ends = new int[meetings.length];
        for (int i = 0; i < meetings.length; i++) {
            starts[i] = meetings[i][0];
            ends[i] = meetings[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int total = 0;
        int count = 0;
        int prev = 0;
        int e = 0;
        for (int s = 0; s < starts.length; s++) {
            while (ends[e] < starts[s]) {
                count--;
                prev = ends[e];
                e++;
            }
            if (count == 0) {
                total += starts[s] - prev - 1;
            }
            count++;
        }
        total += days - ends[ends.length - 1];
        return total;
    }
}
