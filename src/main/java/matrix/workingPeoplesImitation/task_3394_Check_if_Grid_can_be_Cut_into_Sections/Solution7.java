package matrix.workingPeoplesImitation.task_3394_Check_if_Grid_can_be_Cut_into_Sections;

import java.util.Arrays;

// from leetcode code sample (4)
public class Solution7 {

    public boolean checkIfCutPossible(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);

        int count = 0;
        int maxEnd = -1;
        for (int i = 0; i < n; i++) {
            if (intervals[i][0] >= maxEnd) ++count;
            maxEnd = Math.max(maxEnd, intervals[i][1]);
        }

        return count >= 3;
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        int m = rectangles.length;
        int[][] intervals = new int[m][2];

        int index = 0;
        for (var rectangle : rectangles) {
            intervals[index][0] = rectangle[0];
            intervals[index++][1] = rectangle[2];
        }

        boolean cutPossible = checkIfCutPossible(intervals);
        if (cutPossible) {
            return true;
        }

        index = 0;
        for (var rectangle : rectangles) {
            intervals[index][0] = rectangle[1];
            intervals[index++][1] = rectangle[3];
        }

        return checkIfCutPossible(intervals);
    }
}
