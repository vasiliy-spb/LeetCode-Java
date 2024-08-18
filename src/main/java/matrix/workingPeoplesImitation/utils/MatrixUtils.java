package matrix.workingPeoplesImitation.utils;

public class MatrixUtils {

    // сравнивает две двумерных матрицы между собой (ожидает матрицы одинакового размера)
    public static boolean areMatrixEquals(int[][] matrix1, int[][] matrix2) {
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // печатает двумерную матрицу в консоль
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
