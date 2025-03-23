package matrix.workingPeoplesImitation.task_632_Smallest_Range_Covering_Elements_from_K_Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// from leetcode code sample (6)
public class Solution11 {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) list.add(new int[]{num, i});
        }

        Collections.sort(list, Comparator.comparingInt(o -> o[0]));

        int[] rowCounts = new int[nums.size()];
        int i = 0, j = 0, start = -1;
        int len = Integer.MAX_VALUE;
        int counter = 0;
        while (j < list.size()) {
            int[] cur = list.get(j);
            if (rowCounts[cur[1]] == 0) counter++;
            rowCounts[cur[1]]++;
            while (counter == nums.size()) {
                if (list.get(j)[0] - list.get(i)[0] < len) {
                    start = list.get(i)[0];
                    len = list.get(j)[0] - list.get(i)[0];
                }
                int[] d = list.get(i);
                rowCounts[d[1]]--;
                if (rowCounts[d[1]] == 0) counter--;
                i++;
            }
            j++;
        }
        return new int[]{start, start + len};
    }
}
