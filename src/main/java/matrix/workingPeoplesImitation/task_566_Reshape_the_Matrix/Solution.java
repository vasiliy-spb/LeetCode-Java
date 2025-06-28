package matrix.workingPeoplesImitation.task_566_Reshape_the_Matrix;

// my solution
public class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        if (n * m != r * c) {
            return mat;
        }
        int y = 0;
        int x = 0;
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (x >= m) {
                    x = 0;
                    y++;
                }
                matrix[i][j] = mat[y][x++];
            }
        }
        return matrix;
    }
}
