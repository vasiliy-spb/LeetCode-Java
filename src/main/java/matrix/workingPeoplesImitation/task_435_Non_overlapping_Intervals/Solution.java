package matrix.workingPeoplesImitation.task_435_Non_overlapping_Intervals;

import matrix.workingPeoplesImitation.training.IntervalPrinter;

import java.util.*;

public class Solution {

    public int eraseOverlapIntervals0(int[][] intervals) {
//        IntervalPrinter.drawInterval(intervals);
        Arrays.sort(intervals, (i1,i2) -> i1[0] - i2[0]);
        IntervalPrinter.drawInterval(intervals);
        int count = 0;
        int lastStart = intervals[intervals.length - 1][0];
        for (int i = intervals.length - 2; i >= 0; i--) {
            int[] interval = intervals[i];
            if (interval[1] > lastStart) count++;
            else lastStart = interval[0];
        }
        return count;
    }


    // my solution (after hint from GPT)
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);
        IntervalPrinter.drawInterval(intervals);
        int count = 0;
        int lastEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] < lastEnd) count++;
            else lastEnd = interval[1];
        }

        return count;
    }


    // my previous tryings
    static class Interval {
        int number;
        int start;
        int end;

        public Interval(int number, int start, int end) {
            this.number = number;
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return number == interval.number;
        }

        @Override
        public int hashCode() {
            return number;
        }

        @Override
        public String toString() {
            return number + ":" + start + "-" + end;
        }
    }

    public int eraseOverlapIntervals3(int[][] intervals) {
        Map<Interval, List<Interval>> overlapMap = buildOverlapGraphMap(intervals);
        TreeSet<Interval> set = new TreeSet<>((i1, i2) -> {
            int sizeComparison = overlapMap.get(i2).size() - overlapMap.get(i1).size();
            return sizeComparison == 0 ? Integer.compare(i1.number, i2.number) : sizeComparison;
        });
        set.addAll(overlapMap.keySet());
        System.out.println("overlapMap = " + overlapMap);
        System.out.println("set = " + set);
        int count = 0;

        for (Interval interval : set) {
            System.out.println("overlapMap = " + overlapMap);
            List<Interval> list = overlapMap.get(interval);
            if (list != null && list.size() > 0) {
                count++;
                for (Interval intrv : list) {
                    if (overlapMap.get(intrv) != null) overlapMap.get(intrv).remove(interval);
                }
            }
        }
        System.out.println();
        return count;
    }

    public Map<Interval, List<Interval>> buildOverlapGraphMap(int[][] intervals) {
        Map<Interval, List<Interval>> result = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            List<Interval> overlapList = new ArrayList<>();
            Interval interval1 = new Interval(i, interval[0], interval[1]);
            for (int j = 0; j < intervals.length; j++) {
                if (j == i) continue;
                int[] otherInterval = intervals[j];
                Interval interval2 = new Interval(j, otherInterval[0], otherInterval[1]);
                if (isOverlap(interval1, interval2)) overlapList.add(interval2);
            }
            result.put(interval1, overlapList);
        }
        return result;
    }

    public boolean isOverlap(Interval interval1, Interval interval2) {
        return interval1.start < interval2.end && interval2.start < interval1.end;
    }

    public int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals, (interval1, interval2) -> {
            if (interval1[0] == interval2[0]) {
                return interval2[1] - interval1[1];
            }
            return interval1[0] - interval2[0];
        });
        Map<Interval, Set<Interval>> intervalMap = new HashMap<>();
        List<Interval> intervalList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interv = intervals[i];
            intervalList.add(new Interval(i, interv[0], interv[1]));
        }
        for (Interval interval1 : intervalList) {
            for (Interval interval2 : intervalList) {
                if (isOverlap(interval1, interval2)) {
                    intervalMap.computeIfAbsent(interval1, interval -> new HashSet<>()).add(interval2);
                    intervalMap.computeIfAbsent(interval2, interval -> new HashSet<>()).add(interval1);
                }
            }
        }

        TreeMap<Interval, Set<Interval>> intervalTreeMap = new TreeMap<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return intervalMap.get(i2).size() - intervalMap.get(i1).size();
            }
        });
        intervalTreeMap.putAll(intervalMap);

        int count = 0;

        List<Interval> list = intervalTreeMap.keySet().stream().toList();

        for (Interval interval : list) {
            Set<Interval> set = intervalMap.remove(interval);
            if (set != null && !set.isEmpty()) {
                count++;
                for (Interval interval1 : set) {
                    intervalMap.get(interval1).remove(interval);
                }
            }
        }

        return count;
    }

    public int eraseOverlapIntervals1(int[][] intervals) {
        Arrays.sort(intervals, (interval1, interval2) -> {
            if (interval1[0] == interval2[0]) {
                return interval2[1] - interval1[1];
            }
            return interval1[0] - interval2[0];
        });
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval1 = intervals[i - 1];
            int[] interval2 = intervals[i];
            if (isOverlap(interval1, interval2)) count++;
        }
        return count;
    }

    public boolean isOverlap(int[] interval1, int[] interval2) {
        return interval1[0] < interval2[1] && interval2[0] < interval1[1];
    }


    public List<List<Interval>> buildOverlapGraphList(int[][] intervals) {
        List<List<Interval>> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            List<Interval> overlapList = new ArrayList<>();
            Interval interval1 = new Interval(i, interval[0], interval[1]);
            for (int j = 0; j < intervals.length; j++) {
                int[] otherInterval = intervals[j];
                Interval interval2 = new Interval(j, otherInterval[0], otherInterval[1]);
                if (isOverlap(interval1, interval2)) overlapList.add(interval2);
            }
            result.add(overlapList);
        }
        return result;
    }


}
