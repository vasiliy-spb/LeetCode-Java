package matrix.workingPeoplesImitation.task_3033_Modify_the_Matrix;

// my solution
public class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] max = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max[j] = Math.max(max[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] < 0) {
                    matrix[i][j] = max[j];
                }
            }
        }
        return matrix;
    }
}
