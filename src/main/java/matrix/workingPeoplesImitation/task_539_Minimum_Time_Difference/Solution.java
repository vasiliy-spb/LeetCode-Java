package matrix.workingPeoplesImitation.task_539_Minimum_Time_Difference;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// my solution
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        Set<Integer> timeSet = new TreeSet<>();
        for (String timePoint : timePoints) {
            timeSet.add(parseTime(timePoint));
        }
        if (timeSet.size() < timePoints.size()) {
            return 0;
        }
        int[] times = new int[timePoints.size() + 1];
        int index = 0;
        for (int timeInt : timeSet) {
            times[index++] = timeInt;
        }
        times[index] = times[0] + 24 * 60;
        int minDiff = 24 * 60;
        for (int i = 1; i < times.length; i++) {
            minDiff = Math.min(minDiff, times[i] - times[i - 1]);
        }
        return minDiff;
    }
    public int findMinDifference0(List<String> timePoints) {
        Set<Integer> timeSet = new TreeSet<>();
        for (String timePoint : timePoints) {
            timeSet.add(parseTime(timePoint));
        }
        if (timeSet.size() < timePoints.size()) {
            return 0;
        }
        int[] times = timeSet.stream().mapToInt(Integer::intValue).toArray();
        int minDiff = 1440 - times[times.length - 1] + times[0];
        for (int i = 1; i < times.length; i++) {
            minDiff = Math.min(minDiff, times[i] - times[i - 1]);
        }
        return minDiff;
    }
    private int parseTime(String time) {
        String[] tArr = time.split(":");
        return Integer.parseInt(tArr[0]) * 60 + Integer.parseInt(tArr[1]);
    }
}
