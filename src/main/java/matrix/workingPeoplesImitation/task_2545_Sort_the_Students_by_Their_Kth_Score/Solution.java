package matrix.workingPeoplesImitation.task_2545_Sort_the_Students_by_Their_Kth_Score;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    // my solution
    public int[][] sortTheStudents(int[][] score, int k) {
        Map<Integer, int[]> map = new TreeMap<>(Comparator.reverseOrder());
        for (int[] arr : score) {
            map.put(arr[k], arr);
        }
        int i = 0;
        for (int[] arr : map.values()) {
            score[i++] = arr;
        }
        return score;
    }

    // from walkccc.me
    public int[][] sortTheStudents2(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);
        return score;
    }
}
