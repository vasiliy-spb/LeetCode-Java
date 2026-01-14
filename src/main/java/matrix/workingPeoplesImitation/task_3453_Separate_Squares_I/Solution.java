package matrix.workingPeoplesImitation.task_3453_Separate_Squares_I;

// my solution
public class Solution {
    public double separateSquares(int[][] squares) {
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        long totalSquare = 0;
        for (int[] square : squares) {
            min = Math.min(min, square[1]);
            max = Math.max(max, square[1] + square[2]);
            totalSquare += (long) square[2] * square[2];
        }
        double eps = 1e-6;
        double target = totalSquare / 2.0;

        double ans = min;
        while (max - min > eps) {
            double middle = (min + max) / 2;

            double topSquare = calculateAreaAbove(middle, squares);

            if (topSquare > target + eps) {
                min = middle;
            } else if (topSquare < target - eps) {
                max = middle;
            } else {
                ans = middle;
                max = middle;
            }

        }

        if (Math.abs(calculateAreaAbove(min, squares) - target) > eps) {
            ans = min;
        }

        return ans;
    }

    private double calculateAreaAbove(double currentY, int[][] squares) {
        double squareSum = 0;
        for (int[] square : squares) {
            int y = square[1];
            double side = square[2];
            if (y >= currentY) {
                squareSum += side * side;
            } else if (y + side >= currentY) {
                double topSubside = side - (currentY - y);
                squareSum += topSubside * side;
            }
        }
        return squareSum;
    }
}
