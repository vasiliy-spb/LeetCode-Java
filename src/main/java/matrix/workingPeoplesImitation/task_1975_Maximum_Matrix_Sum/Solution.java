package matrix.workingPeoplesImitation.task_1975_Maximum_Matrix_Sum;

// my solution
public class Solution {
    public long maxMatrixSum(int[][] matrix)  {
        int countNegative = 0;
        int absMin = 100_001;
        int n = matrix.length;
        long sum = 0;
        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                if (ints[j] < 0) {
                    countNegative++;
                }
                int currentAbs = Math.abs(ints[j]);
                absMin = Math.min(absMin, currentAbs);
                sum += currentAbs;
            }
        }
        if (countNegative % 2 == 1) {
            return sum - absMin * 2L;
        }
        return sum;
    }
}
