package matrix.workingPeoplesImitation.task_74_Search_a_2D_Matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearchRow(matrix, target);
        System.out.println("row = " + row);
        int num = binarySearchNum(matrix[row], target);
        System.out.println("num = " + num);
        return matrix[row][num] == target;
    }

    private int binarySearchNum(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (target == row[middle]) return middle;
            if (target < row[middle]) right = middle;
            else left = middle + 1;
        }
        return left;
    }

    private int binarySearchRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (target >= matrix[middle][0] && target <= matrix[middle][matrix[middle].length - 1]) return middle;
            if (target < matrix[middle][matrix[middle].length - 1]) right = middle;
            else left = middle + 1;
        }
        return left;
    }
}
