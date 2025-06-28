package matrix.workingPeoplesImitation.task_452_Minimum_Number_of_Arrows_to_Burst_Balloons;

import matrix.workingPeoplesImitation.training.IntervalPrinter;

import java.util.*;

public class Solution {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1, p2) -> {
            if (p1[1] == p2[1]) {
                return Integer.compare(p1[0], p2[0]);
            }
            return Integer.compare(p1[1], p2[1]);
        });

        int count = 1;
        int lastEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] interval = points[i];

            if (interval[0] > lastEnd) {
                count++;
                lastEnd = interval[1];
            } else {
                lastEnd = Math.min(lastEnd, interval[1]);
            }

        }
        return count;
    }

    public int findMinArrowShots1(int[][] points) {
//        Arrays.sort(points, (p1, p2) -> p1[0] - p2[0]);
        Arrays.sort(points, (p1, p2) -> {
            if (p1[1] == p2[1]) {
//                return (p2[1] - p2[0]) - (p1[1] - p1[0]);
                return p1[0] - p2[0];
            }
            return p1[1] - p2[1];
        });
        for (int[] interval : points)
            System.out.println("interval = " + Arrays.toString(interval));
        Set<Integer> intersectIndexSet = countNonIntersectingIntervals(points);
//        Set<Integer> innerIndexSet = countInnerIntervals(points);
        IntervalPrinter.drawInterval(points);
        if (points.length == intersectIndexSet.size()) return intersectIndexSet.size();
        int count = 1;
        int lastEnd = points[0][1];
        int lastStart = points[0][0];
        for (int i = 1; i < points.length; i++) {
//            if (intersectIndexSet.contains(i)) continue;
//            if (innerIndexSet.contains(i)) continue;
            int[] interval = points[i];
            if (interval[0] == lastStart && interval[1] == lastEnd) continue;
            if (interval[1] < lastEnd) {
                count++;
                continue;
            }
            if (interval[0] <= lastEnd) count++;
            else lastEnd = Math.min(lastEnd, interval[1]);
        }
//        System.out.println("count = " + count);
//        int countOut = 0;
//        int countIn = 0;
//        for (int i = 0; i < points.length; i++) {
//            int[] interval1 = points[i];
//            boolean match = false;
//            for (int j = 0; j < points.length; j++) {
//                if (i == j) continue;
//                int[] interval2 = points[j];
//                if (interval1[0] > interval2[0] && interval1[1] < interval2[1]) {
//                    count++;
//                    match = true;
//                    continue;
//                }
//                if (interval1[1] >= interval2[0] && interval1[0] <= interval2[1]) match = true;
////                if (interval1[1] < interval2[0] || interval1[0] > interval2[1]) ;
////                else match = true;
//            }
//            if (!match) count++;
//        }


        int countNonIntersect = intersectIndexSet.size();
//        System.out.println("countNonIntersect = " + countNonIntersect);

//        System.out.println("count = " + count);
//        System.out.println("countIn = " + countIn);
//        System.out.println("countOut = " + countOut);
        return count + countNonIntersect;
//        return count;
    }

    private Set<Integer> countInnerIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new HashSet<>();
        }
        Set<Integer> indexSet = new HashSet<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval1 = intervals[i];
            for (int j = 0; j < intervals.length; j++) {
                if (i == j) continue;
                int[] interval2 = intervals[j];
                if (interval1[0] > interval2[0] && interval1[1] < interval2[1]) indexSet.add(i);
                if (interval2[0] > interval1[0] && interval2[1] < interval1[1]) indexSet.add(j);
            }
        }
        return indexSet;
    }

    public static Set<Integer> countNonIntersectingIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new HashSet<>();
        }
        Set<Integer> indexSet = new HashSet<>();
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval1 = intervals[i];
            boolean hasIntersect = false;
            for (int j = 0; j < intervals.length; j++) {
                if (i == j) continue;
                int[] interval2 = intervals[j];
                if (interval1[1] >= interval2[0] && interval1[1] <= interval2[1]) {
                    hasIntersect = true;
                    break;
                }
                if (interval2[1] >= interval1[0] && interval2[1] <= interval1[1]) {
                    hasIntersect = true;
                    break;
                }
            }
            if (!hasIntersect) {
                indexSet.add(i);
                count++;
            }
        }
        return indexSet;
    }

}
