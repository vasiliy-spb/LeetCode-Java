package matrix.workingPeoplesImitation.task_74_Search_a_2D_Matrix;

// my solution
public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            int i = middle / m;
            int j = middle % m;
            if (matrix[i][j] >= target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return matrix[left / m][left % m] == target;
    }
}
