package matrix.workingPeoplesImitation.task_1329_Sort_the_Matrix_Diagonally;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[][] mat = {
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}};
        int[][] expected = {
                {1, 1, 1, 1},
                {1, 2, 2, 2},
                {1, 2, 3, 3}};
        System.out.println("Origin:");
        printMatrix(mat);
        testingClass.diagonalSort(mat);
        System.out.println("In real:");
        printMatrix(mat);
        System.out.println("Expected:");
        printMatrix(expected);
        assertTrue(areMatrixEquals(expected, mat));
    }

    @Test
    public void checkTestcase02() {
        int[][] mat = {{11, 25, 66, 1, 69, 7}, {23, 55, 17, 45, 15, 52}, {75, 31, 36, 44, 58, 8}, {22, 27, 33, 25, 68, 4}, {84, 28, 14, 11, 5, 50}};
        int[][] expected = {{5, 17, 4, 1, 52, 7}, {11, 11, 25, 45, 8, 69}, {14, 23, 25, 44, 58, 15}, {22, 27, 31, 36, 50, 66}, {84, 28, 75, 33, 55, 68}};
        System.out.println("Origin:");
        printMatrix(mat);
        testingClass.diagonalSort(mat);
        System.out.println("In real:");
        printMatrix(mat);
        System.out.println("Expected:");
        printMatrix(expected);
        assertTrue(areMatrixEquals(expected, mat));
    }

    //    @Test
//    public void checkTestcase03() {
//        int[][] mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]];
//        int[][] expected = [[1,1,1,1],[1,2,2,2],[1,2,3,3]];
//        testingClass.diagonalSort(mat);
//        assertTrue(areMatrixEquals(expected, mat));
//    }
    private boolean areMatrixEquals(int[][] matrix1, int[][] matrix2) {
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
