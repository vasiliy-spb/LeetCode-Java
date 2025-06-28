package matrix.workingPeoplesImitation.task_729_My_Calendar_I;

import java.util.Set;
import java.util.TreeSet;

// my solution
public class MyCalendar {
    Set<int[]> intervals;
    public MyCalendar() {
        this.intervals = new TreeSet<>((i1, i2) -> Integer.compare(i1[0], i2[0]));
    }

    public boolean book(int start, int end) {
        int[] currentInterval = {start, end};
        for (int[] interval : intervals) {
            if (hasIntersect(interval, currentInterval)) {
                return false;
            }
        }
        intervals.add(currentInterval);
        return true;
    }
    private boolean hasIntersect(int[] interval1, int[] interval2) {
        if (interval1[0] > interval2[0]) {
            return hasIntersect(interval2, interval1);
        }
        return interval1[1] > interval2[0];
    }
}
