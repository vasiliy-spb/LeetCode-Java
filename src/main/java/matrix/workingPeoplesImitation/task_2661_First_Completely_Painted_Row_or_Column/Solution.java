package matrix.workingPeoplesImitation.task_2661_First_Completely_Painted_Row_or_Column;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// my solution
public class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> columns = new HashMap<>();
        Map<Integer, Integer> rowNumber = new HashMap<>();
        Map<Integer, Integer> columnNumber = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            if (!rows.containsKey(i)) {
                rows.put(i, new HashSet<>());
            }
            for (int j = 0; j < mat[0].length; j++) {
                if (!columns.containsKey(j)) {
                    columns.put(j, new HashSet<>());
                }
                rows.get(i).add(mat[i][j]);
                columns.get(j).add(mat[i][j]);
                rowNumber.put(mat[i][j], i);
                columnNumber.put(mat[i][j], j);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int row = rowNumber.get(arr[i]);
            int column = columnNumber.get(arr[i]);
            rows.get(row).remove(arr[i]);
            columns.get(column).remove(arr[i]);
            if (rows.get(row).isEmpty() || columns.get(column).isEmpty()) {
                return i;
            }
        }
        return -1;
    }
}
