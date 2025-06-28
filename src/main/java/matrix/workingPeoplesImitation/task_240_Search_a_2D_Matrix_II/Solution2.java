package matrix.workingPeoplesImitation.task_240_Search_a_2D_Matrix_II;

// from walkccc.me
public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[0].length - 1;

        while (r <= matrix.length && c >= 0) {
            if (matrix[r][c] == target)
                return true;
            if (matrix[r][c] > target)
                --c;
            else
                ++r;
        }

        return false;
    }
}
