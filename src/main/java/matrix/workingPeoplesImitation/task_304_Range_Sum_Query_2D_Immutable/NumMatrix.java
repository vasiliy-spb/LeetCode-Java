package matrix.workingPeoplesImitation.task_304_Range_Sum_Query_2D_Immutable;

public class NumMatrix {
    private int[][] matrix;
    private int[][] prefixSumMatrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.prefixSumMatrix = calculatePrefixSumMatrix(matrix);
    }

    private int[][] calculatePrefixSumMatrix(int[][] matrix) {
        int[][] prefixSumMatrix = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            prefixSumMatrix[i][0] = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                prefixSumMatrix[i][j + 1] = prefixSumMatrix[i][j] + matrix[i][j];
            }
        }
        return prefixSumMatrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int count = 0;
        for (int i = row1; i <= row2; i++) {
            count += prefixSumMatrix[i][col2 + 1] - prefixSumMatrix[i][col1];
        }
        return count;
    }
}
