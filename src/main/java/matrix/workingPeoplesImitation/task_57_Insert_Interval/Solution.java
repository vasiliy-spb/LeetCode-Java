package matrix.workingPeoplesImitation.task_57_Insert_Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    // переписал по памяти с walkccc.me
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalList = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0])
            intervalList.add(intervals[i++]);

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        intervalList.add(newInterval);

        while (i < n)
            intervalList.add(intervals[i++]);

        return intervalList.toArray(int[][] ::new);
    }

    // my solution
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        List<int[]> intervalList = new ArrayList<>();
        if (newInterval[1] < intervals[0][0]) intervalList.add(newInterval);
        for (int i = 0; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if (currentInterval[1] < newInterval[0] || currentInterval[0] > newInterval[1]) {
                intervalList.add(currentInterval);
                if (i < intervals.length - 1 && newInterval[0] > currentInterval[1] && newInterval[1] < intervals[i + 1][0])
                    intervalList.add(newInterval);
                continue;
            }
            newInterval[0] = Math.min(newInterval[0], currentInterval[0]);
            newInterval[1] = Math.max(newInterval[1], currentInterval[1]);
            if (i == intervals.length - 1 ||
                    currentInterval[1] == newInterval[1] ||
                    (i < intervals.length - 1 && intervals[i + 1][0] > newInterval[1]))
                intervalList.add(newInterval);
        }
        if (newInterval[0] > intervals[intervals.length - 1][1]) intervalList.add(newInterval);
        int[][] result = new int[intervalList.size()][2];
        for (int i = 0; i < intervalList.size(); i++) {
            result[i] = intervalList.get(i);
        }
        return result;
    }

    // from walkccc.me
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        final int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int i = 0;

        while (i < n && intervals[i][1] < newInterval[0])
            ans.add(intervals[i++]);

        // Merge overlapping intervals.
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            ++i;
        }

        ans.add(newInterval);

        while (i < n)
            ans.add(intervals[i++]);

        return ans.toArray(int[][] ::new);
    }

    // from leetcode solutions
    public int[][] insert3(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        // Iterate through all slots
        for(int[] slot : intervals)
        {

            // if newInterval before slot insert newInterval & update slot as new interval
            if(newInterval[1] < slot[0])
            {
                result.add(newInterval);
                newInterval = slot;
            }

            // if slot is lesser than new Interval insert slot
            else if(slot[1] < newInterval[0])
            {
                result.add(slot);
            }

            // if above conditions fail its an overlap since possibility of new interval existing in left & right of slot is checked
            // update lowest of start & highest of end & not insert
            else {
                newInterval[0] = Math.min(newInterval[0],slot[0]);
                newInterval[1] = Math.max(newInterval[1],slot[1]);
            }
        }

        // insert the last newInterval
        result.add(newInterval);

        // convert to int[][] array
        return result.toArray(new int[result.size()][]);
    }

    // from leetcode solutions
    public int[][] insert4(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int[] toAdd = newInterval;

        for (int i = 0; i < intervals.length; i ++) {
            /*1. No overlap and toAdd appears before current interval, add toAdd to result.*/
            if (intervals[i][0] > toAdd[1]) {
                ans.add(toAdd);
                toAdd = intervals[i];
            }
            /*2. Has overlap, update the toAdd to the merged interval.*/
            else if (intervals[i][1] >= toAdd[0])
                toAdd = new int[] {Math.min(intervals[i][0], toAdd[0]),
                        Math.max(intervals[i][1], toAdd[1]) };
                /*3. No overlap and toAdd appears after current interval, add current interval to result.*/
            else ans.add(intervals[i]);
        }
        ans.add(toAdd);
        return ans.toArray(new int[ans.size()][2]);
    }
}
