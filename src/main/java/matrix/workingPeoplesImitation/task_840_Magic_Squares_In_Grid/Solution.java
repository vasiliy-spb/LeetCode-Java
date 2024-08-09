package matrix.workingPeoplesImitation.task_840_Magic_Squares_In_Grid;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    // my solution
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isMagicSquare(int[][] grid, int i, int j) {
        if (grid.length - i < 3) {
            return false;
        }
        if (grid[i].length - j < 3) {
            return false;
        }
        Set<Integer> nums = new HashSet<>();
        int[] rowSum = new int[3];
        int[] colSum = new int[3];
        for (int n = i, r = -n; n < i + 3; n++) {
            for (int m = j, c = -m; m < j + 3; m++) {
                if (grid[n][m] < 1 || grid[n][m] > 9) {
                    return false;
                }
                if (nums.contains(grid[n][m])) {
                    return false;
                }
                nums.add(grid[n][m]);
                rowSum[r + n] += grid[n][m];
                colSum[c + m] += grid[n][m];
            }
        }
        int aDiagonal = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        int bDiagonal = grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2];
        if (aDiagonal != bDiagonal) {
            return false;
        }
        for (int r : rowSum) {
            if (r != aDiagonal) {
                return false;
            }
        }
        for (int c : colSum) {
            if (c != aDiagonal) {
                return false;
            }
        }
        return true;
    }

    // from leetcode editorial (Approach 2: Check Unique Properties of Magic Square)
    public int numMagicSquaresInside2(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int row = 0; row + 2 < m; row++) {
            for (int col = 0; col + 2 < n; col++) {
                if (isMagicSquare2(grid, row, col)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isMagicSquare2(int[][] grid, int row, int col) {
        // The sequences are each repeated twice to account for
        // the different possible starting points of the sequence
        // in the magic square
        String sequence = "2943816729438167";
        String sequenceReversed = "7618349276183492";

        StringBuilder border = new StringBuilder();
        // Flattened indices for bordering elements of 3x3 grid
        int[] borderIndices = new int[] { 0, 1, 2, 5, 8, 7, 6, 3 };
        for (int i : borderIndices) {
            int num = grid[row + i / 3][col + (i % 3)];
            border.append(num);
        }

        String borderConverted = border.toString();

        // Make sure the sequence starts at one of the corners
        return (
                grid[row][col] % 2 == 0 &&
                        (sequence.contains(borderConverted) ||
                                sequenceReversed.contains(borderConverted)) &&
                        grid[row + 1][col + 1] == 5
        );
    }

    // from walkccc.me
    public int numMagicSquaresInside3(int[][] grid) {
        int ans = 0;

        for (int i = 0; i + 2 < grid.length; ++i)
            for (int j = 0; j + 2 < grid[0].length; ++j)
                if (grid[i][j] % 2 == 0 && grid[i + 1][j + 1] == 5)
                    if (isMagic(grid, i, j))
                        ++ans;

        return ans;
    }

    private boolean isMagic(int[][] grid, int i, int j) {
        String s = new String("");

        for (final int num : new int[] {0, 1, 2, 5, 8, 7, 6, 3})
            s += Integer.toString(grid[i + num / 3][j + num % 3]);

        return                                            //
                new String("4381672943816729").contains(s) || //
                        new String("9276183492761834").contains(s);
    }

}
