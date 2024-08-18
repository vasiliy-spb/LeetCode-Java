package matrix.workingPeoplesImitation.task_1937_Maximum_Number_of_Points_with_Cost;

import java.util.Arrays;

public class Solution {

    // my solution
    public long maxPoints(int[][] points) {
        if (points[0].length == 1) {
            long sum = 0;
            for (int[] p : points) {
                sum += p[0];
            }
            return sum;
        }
        int[] dp = new int [points[0].length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                if (i > 0) dp[j] = getMaxProfit(points[i - 1], j);
                points[i][j] += dp[j];
            }
        }
        return Arrays.stream(points[points.length - 1]).max().getAsInt();
    }
    private int getMaxProfit(int[] row, int col) {
        int max = 0;
        for (int i = 0; i < row.length; i++) {
            max = Math.max(max, row[i] - Math.abs(col - i));
        }
        return max;
    }

    // from leetcode editorial (Approach 1: Dynamic Programming)
    public long maxPoints2(int[][] points) {
        int rows = points.length, cols = points[0].length;
        long[] previousRow = new long[cols];

        // Initialize the first row
        for (int col = 0; col < cols; ++col) {
            previousRow[col] = points[0][col];
        }

        // Process each row
        for (int row = 0; row < rows - 1; ++row) {
            long[] leftMax = new long[cols];
            long[] rightMax = new long[cols];
            long[] currentRow = new long[cols];

            // Calculate left-to-right maximum
            leftMax[0] = previousRow[0];
            for (int col = 1; col < cols; ++col) {
                leftMax[col] = Math.max(leftMax[col - 1] - 1, previousRow[col]);
            }

            // Calculate right-to-left maximum
            rightMax[cols - 1] = previousRow[cols - 1];
            for (int col = cols - 2; col >= 0; --col) {
                rightMax[col] = Math.max(
                        rightMax[col + 1] - 1,
                        previousRow[col]
                );
            }

            // Calculate the current row's maximum points
            for (int col = 0; col < cols; ++col) {
                currentRow[col] = points[row + 1][col] +
                        Math.max(leftMax[col], rightMax[col]);
            }

            // Update previousRow for the next iteration
            previousRow = currentRow;
        }

        // Find the maximum value in the last processed row
        long maxPoints = 0;
        for (int col = 0; col < cols; ++col) {
            maxPoints = Math.max(maxPoints, previousRow[col]);
        }

        return maxPoints;
    }

    // from leetcode editorial (Approach 2: Dynamic Programming (Optimized))
    public long maxPoints3(int[][] points) {
        int cols = points[0].length;
        long[] currentRow = new long[cols], previousRow = new long[cols];

        for (int[] row : points) {
            // runningMax holds the maximum value generated in the previous iteration of each loop
            long runningMax = 0;

            // Left to right pass
            for (int col = 0; col < cols; ++col) {
                runningMax = Math.max(runningMax - 1, previousRow[col]);
                currentRow[col] = runningMax;
            }

            runningMax = 0;
            // Right to left pass
            for (int col = cols - 1; col >= 0; --col) {
                runningMax = Math.max(runningMax - 1, previousRow[col]);
                currentRow[col] = Math.max(currentRow[col], runningMax) +
                        row[col];
            }

            // Update previousRow for next iteration
            previousRow = currentRow;
        }

        // Find maximum points in the last row
        long maxPoints = 0;
        for (int col = 0; col < cols; ++col) {
            maxPoints = Math.max(maxPoints, previousRow[col]);
        }

        return maxPoints;
    }

    // from walkccc.me
    public long maxPoints4(int[][] points) {
        final int n = points[0].length;
        // dp[j] := the maximum number of points you can have if points[i][j] is the
        // most recent cell you picked
        long[] dp = new long[n];

        for (int[] row : points) {
            long[] leftToRight = new long[n];
            long runningMax = 0;

            for (int j = 0; j < n; ++j) {
                runningMax = Math.max(runningMax - 1, dp[j]);
                leftToRight[j] = runningMax;
            }

            long[] rightToLeft = new long[n];
            runningMax = 0;

            for (int j = n - 1; j >= 0; --j) {
                runningMax = Math.max(runningMax - 1, dp[j]);
                rightToLeft[j] = runningMax;
            }

            for (int j = 0; j < n; ++j)
                dp[j] = Math.max(leftToRight[j], rightToLeft[j]) + row[j];
        }

        return Arrays.stream(dp).max().getAsLong();
    }

}