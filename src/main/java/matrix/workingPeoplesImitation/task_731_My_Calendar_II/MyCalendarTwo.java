package matrix.workingPeoplesImitation.task_731_My_Calendar_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// my solution
public class MyCalendarTwo {
    List<int[]> intervals;
    Map<Integer, Integer> intersections;
    public MyCalendarTwo() {
        this.intervals = new ArrayList<>();
        this.intersections = new HashMap<>();
    }

    public boolean book(int start, int end) {
        int[] currentInterval = new int[]{start, end};
        for (Map.Entry<Integer, Integer> interval : intersections.entrySet()) {
            if (hasIntersect(new int[]{interval.getKey(), interval.getValue()}, currentInterval)) {
                return false;
            }
        }

        for (int[] interval : intervals) {
            if (hasIntersect(interval, currentInterval)) {
                addIntersect(interval, currentInterval);
            }
        }
        intervals.add(currentInterval);
        return true;
    }

    private void addIntersect(int[] interval1, int[] interval2) {
        if (interval1[0] > interval2[0]) {
            addIntersect(interval2, interval1);
            return;
        }
        intersections.merge(interval2[0], Math.min(interval1[1], interval2[1]), Integer::max);
    }
    private boolean hasIntersect(int[] interval1, int[] interval2) {
        if (interval1[0] > interval2[0]) {
            return hasIntersect(interval2, interval1);
        }
        return interval1[1] > interval2[0];
    }
}
