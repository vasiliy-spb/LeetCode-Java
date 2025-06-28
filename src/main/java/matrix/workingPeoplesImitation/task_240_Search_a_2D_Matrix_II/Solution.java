package matrix.workingPeoplesImitation.task_240_Search_a_2D_Matrix_II;

// my solution
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int startRow = 0;
        int finishRow = n - 1;
        while (startRow < n && matrix[startRow][m - 1] <= target) {
            startRow++;
        }
        startRow--;
        while (finishRow > 0 && matrix[finishRow][0] > target) {
            finishRow--;
        }
        finishRow++;
        for (int i = Math.max(0, startRow); i < Math.min(finishRow, n); i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] > target) {
                    break;
                }
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
