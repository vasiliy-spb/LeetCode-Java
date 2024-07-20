package matrix.workingPeoplesImitation.task_1380_Lucky_Numbers_in_a_Matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        Set<Integer> minSet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            minSet.add(min);
        }
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < matrix[0].length; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            if (minSet.contains(max)) {
                result.add(max);
            }
        }
        return result;
    }
}
