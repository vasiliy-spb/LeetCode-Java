package matrix.workingPeoplesImitation.task_1253_Reconstruct_a_2_Row_Binary_Matrix;

import java.util.ArrayList;
import java.util.List;

// my solution
public class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer> upperRow = new ArrayList<>();
        List<Integer> lowerRow = new ArrayList<>();
        for (int sum : colsum) {
            if (sum == 0) {
                upperRow.add(0);
                lowerRow.add(0);
            } else if (sum == 2) {
                upperRow.add(1);
                lowerRow.add(1);
                upper--;
                lower--;
            } else {
                if (upper > lower) {
                    upperRow.add(1);
                    lowerRow.add(0);
                    upper--;
                } else {
                    upperRow.add(0);
                    lowerRow.add(1);
                    lower--;
                }
            }
        }
        if (upper != 0 || lower != 0) {
            return new ArrayList<>();
        }
        return List.of(upperRow, lowerRow);
    }
}
