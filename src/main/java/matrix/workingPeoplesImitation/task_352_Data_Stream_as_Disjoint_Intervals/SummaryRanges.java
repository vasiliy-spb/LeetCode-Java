package matrix.workingPeoplesImitation.task_352_Data_Stream_as_Disjoint_Intervals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class SummaryRanges {
    TreeSet<Integer> nums;
    public SummaryRanges() {
        this.nums = new TreeSet<>();
    }

    public void addNum(int value) {
        nums.add(value);
    }

    public int[][] getIntervals() {
        if (nums.isEmpty()) return new int[0][0];
        List<int[]> intervals = new ArrayList<>();
        int start = nums.first();
        int prev = start;
        Iterator<Integer> iterator = nums.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            if (num - prev > 1) {
                intervals.add(new int[]{start,prev});
                start = num;
            }
            prev = num;
            if (!iterator.hasNext()) intervals.add(new int[]{start,prev});
        }
        return intervals.toArray(int[][] :: new);
    }
}
