package matrix.workingPeoplesImitation.task_56_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (interval1, interval2) -> {
            if (interval1[0] == interval2[0]) {
                return interval1[1] - interval2[1];
            }
            return interval1[0] - interval2[0];
        });
        List<int[]> intervalList = new ArrayList<>();
        int[] interval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if (currentInterval[0] <= interval[1]) interval[1] = Math.max(interval[1], currentInterval[1]);
            else {
                intervalList.add(interval);
                interval = currentInterval;
            }
        }
        intervalList.add(interval);
        int[][] result = new int[intervalList.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = intervalList.get(i);
        }
        return result;
    }
}
