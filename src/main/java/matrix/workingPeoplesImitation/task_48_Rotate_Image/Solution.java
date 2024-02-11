package matrix.workingPeoplesImitation.task_48_Rotate_Image;

public class Solution {

    // my solution
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp;
        for (int i = 0; i < n - i; i++) {
            for (int j = i + 1; j < n - i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
//    matrix
//    0:0 0:1 0:2 0:3 0:4 0:5 0:6 0:7
//    1:0 1:1 1:2 1:3 1:4 1:5 1:6 1:7
//    2:0 2:1 2:2 2:3 2:4 2:5 2:6 2:7
//    3:0 3:1 3:2 3:3 3:4 3:5 3:6 3:7
//    4:0 4:1 4:2 4:3 4:4 4:5 4:6 4:7
//    5:0 5:1 5:2 5:3 5:4 5:5 5:6 5:7
//    6:0 6:1 6:2 6:3 6:4 6:5 6:6 6:7
//    7:0 7:1 7:2 7:3 7:4 7:5 7:6 7:7
//
//    input data
//    n = 8
//    i = 1       j = 2
//
//    replacement order
//    1:2  ->  5:1  ->  6:5  ->  2:6  ->  1:2
//
//    replacements
//    matrix[j][n - 1 - i] = matrix[i][j]
//    matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]
//    matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]
//    matrix[i][j] = matrix[n - 1 - j][i]

    // from walkccc.me (Approach 1: Reverse)
    public void rotate2(int[][] matrix) {
        for (int i = 0, j = matrix.length - 1; i < j; ++i, --j) {
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
        }

        for (int i = 0; i < matrix.length; ++i)
            for (int j = i + 1; j < matrix.length; ++j) {
                final int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
    }

    // from walkccc.me (Approach 2: Indexing)
    public void rotate3(int[][] matrix) {
        for (int min = 0; min < matrix.length / 2; ++min) {
            final int max = matrix.length - min - 1;
            for (int i = min; i < max; ++i) {
                final int offset = i - min;
                final int top = matrix[min][i];
                matrix[min][i] = matrix[max - offset][min];
                matrix[max - offset][min] = matrix[max][max - offset];
                matrix[max][max - offset] = matrix[i][max];
                matrix[i][max] = top;
            }
        }
    }

}



