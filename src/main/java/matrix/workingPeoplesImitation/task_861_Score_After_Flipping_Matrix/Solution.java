package matrix.workingPeoplesImitation.task_861_Score_After_Flipping_Matrix;

public class Solution {

    // my solution
    public int matrixScore(int[][] grid) {
        for (int[] row : grid) {
            if (row[0] == 0) {
                flipRow(row);
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            int countZeros = 0;
            for (int[] row : grid) {
                if (row[i] == 0) {
                    countZeros++;
                }
            }
            if (countZeros > grid.length / 2) {
                flipCol(grid, i);
            }
        }
        return sumRows(grid);
    }

    private void flipRow(int[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                row[i] = 0;
            } else {
                row[i] = 1;
            }
        }
    }

    private void flipCol(int[][] grid, int col) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == 1) {
                grid[i][col] = 0;
            } else {
                grid[i][col] = 1;
            }
        }
    }

    private int sumRows(int[][] grid) {
        int sum = 0;
        for (int[] row : grid) {
            StringBuilder sb = new StringBuilder();
            for (int num : row) {
                sb.append(num);
            }
            sum += Integer.valueOf(sb.toString(), 2);
        }
        return sum;
    }

    // from leetcode editorial (Approach 1: Greedy Way (Modifying Input))
    public int matrixScore2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Set first column
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                // Flip row
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        // Optimize columns except first column
        for (int j = 1; j < n; j++) {
            int countZero = 0;
            // Count zeros
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 0) {
                    countZero++;
                }
            }
            // Flip the column if there are more zeros for better score
            if (countZero > m - countZero) {
                for (int i = 0; i < m; i++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        // Calculate the final score considering bit positions
        int score = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Left shift bit by place value of column to find column contribution
                int columnScore = grid[i][j] << (n - j - 1);
                // Add contribution to score
                score += columnScore;
            }
        }

        // return final result
        return score;
    }

    // from leetcode editorial (Approach 2: Greedy Way (Without Modifying Input))
    public int matrixScore3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Set score to summation of first column
        int score = (1 << (n - 1)) * m;

        // Loop over all other columns
        for (int j = 1; j < n; j++) {
            int countSameBits = 0;
            for (int i = 0; i < m; i++) {
                // Count elements matching first in row
                if (grid[i][j] == grid[i][0]) {
                    countSameBits++;
                }
            }
            // Calculate score based on the number of same bits in a column
            countSameBits = Math.max(countSameBits, m - countSameBits);
            // Calculate the score contribution for the current column
            int columnScore = (1 << (n - j - 1)) * countSameBits;
            // Add contribution to score
            score += columnScore;
        }

        return score;
    }

    // from walkccc.me (Approach 1: Naive Greedy)
    public int matrixScore4(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int ans = 0;

        // Flip the rows with a leading 0.
        for (int[] row : grid)
            if (row[0] == 0)
                flip(row);

        // Flip the columns with 1s < 0s.
        for (int j = 0; j < n; ++j)
            if (onesColCount(grid, j) * 2 < m)
                flipCol2(grid, j);

        // Add a binary number for each row.
        for (int[] row : grid)
            ans += binary(row);

        return ans;
    }

    private void flip(int[] row) {
        for (int i = 0; i < row.length; ++i)
            row[i] ^= 1;
    }

    private int onesColCount(int[][] grid, int j) {
        int ones = 0;
        for (int i = 0; i < grid.length; ++i)
            ones += grid[i][j];
        return ones;
    }

    private void flipCol2(int[][] grid, int j) {
        for (int i = 0; i < grid.length; ++i)
            grid[i][j] ^= 1;
    }

    private int binary(int[] row) {
        int res = row[0];
        for (int j = 1; j < row.length; ++j)
            res = res * 2 + row[j];
        return res;
    }

    // from walkccc.me (Approach 2: Heuristic)
    public int matrixScore5(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int ans = m; // All the cells in the first column are 1.

        for (int j = 1; j < n; ++j) {
            int onesCount = 0;
            for (int i = 0; i < m; ++i)
                // The best strategy is flipping the rows with a leading 0..
                onesCount += grid[i][j] == grid[i][0] ? 1 : 0;
            ans = ans * 2 + Math.max(onesCount, m - onesCount);
        }

        return ans;
    }

}
