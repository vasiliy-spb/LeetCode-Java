package matrix.workingPeoplesImitation.task_73_Set_Matrix_Zeroes;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(j);
                    columns.add(i);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows.contains(j) || columns.contains(i))
                    matrix[i][j] = 0;
            }
        }
    }
}
