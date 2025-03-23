package matrix.workingPeoplesImitation.task_1253_Reconstruct_a_2_Row_Binary_Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// from leetcode code sample (1)
public class Solution2 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        boolean[][] res = new boolean[2][n];

        for (int i = 0; i < n; i++) {
            res[0][i] = colsum[i] == 2 || (colsum[i] == 1 && lower < upper);
            res[1][i] = colsum[i] == 2 || (colsum[i] == 1 && !res[0][i]);
            upper -= res[0][i] ? 1 : 0;
            lower -= res[1][i] ? 1 : 0;
        }

        return (lower == 0 && upper == 0) ? new ArrayList(Arrays.asList(res[0], res[1])) : new ArrayList();
    }
}
