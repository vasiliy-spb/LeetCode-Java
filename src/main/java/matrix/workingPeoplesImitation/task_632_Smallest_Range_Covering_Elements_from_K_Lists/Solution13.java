package matrix.workingPeoplesImitation.task_632_Smallest_Range_Covering_Elements_from_K_Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// from leetcode code sample (8)
public class Solution13 {
    record Point(int row, int col, int value) {
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.isEmpty()) return new int[0];

        List<Point> points = new ArrayList<Point>();
        for (int row = 0; row < nums.size(); row++) {
            for (int col = 0; col < nums.get(row).size(); col++) {
                points.add(new Point(row, col, nums.get(row).get(col)));
            }
        }

        Collections.sort(points, Comparator.comparingInt(o -> o.value));

        int[] counts = new int[nums.size()];
        int counter = 0, start = -100001, end = 100001;
        for (int i = 0, j = 0; j < points.size(); j++) {
            if (counts[points.get(j).row] == 0) counter++;
            counts[points.get(j).row]++;
            while (counter == nums.size()) {
                if (points.get(j).value - points.get(i).value < end - start) {
                    start = points.get(i).value;
                    end = points.get(j).value;
                }
                counts[points.get(i).row]--;
                if (counts[points.get(i).row] == 0) counter--;
                i++;
            }
        }

        return new int[]{start, end};
    }
}
