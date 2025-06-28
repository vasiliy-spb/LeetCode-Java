package matrix.workingPeoplesImitation.task_3239_Minimum_Number_of_Flips_to_Make_Binary_Grid_Palindromic_I;

public class Solution {

    // my solution
    public int minFlips(int[][] grid) {
        int countHorizontalFlips = calculateHorizontalFlips(grid);
        int countVerticalFlips = calculateVerticalFlips(grid);
        return Math.min(countHorizontalFlips, countVerticalFlips);
    }


    private int calculateHorizontalFlips(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            count += calculateRowFlips(row);
        }
        return count;
    }

    private int calculateRowFlips(int[] row) {
        int count = 0;
        int left = 0;
        int right = row.length - 1;
        while (left < right) {
            if (row[left++] != row[right--]) {
                count++;
            }
        }
        return count;
    }

    private int calculateVerticalFlips(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int top = 0;
            int bottom = grid.length - 1;
            while (top < bottom) {
                if (grid[top++][i] != grid[bottom--][i]) {
                    count++;
                }
            }
        }
        return count;
    }

    // from walkccc.me
    public int minFlips2(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int rowFlips = 0;
        int colFlips = 0;

        for (int[] row : grid)
            for (int i = 0; i < n / 2; ++i)
                if (row[i] != row[n - 1 - i])
                    ++rowFlips;

        for (int j = 0; j < n; ++j)
            for (int i = 0; i < m / 2; ++i)
                if (grid[i][j] != grid[m - 1 - i][j])
                    ++colFlips;

        return Math.min(rowFlips, colFlips);
    }

    // from leetcode code sample
    public int minFlips3(int[][] grid) {
        int rowResult = 0,
                colResult = 0,
                rowSize = grid.length,
                colSize = grid[0].length;
        for (int[] row : grid)
            for (int left = 0, right = colSize - 1; left < right; )
                rowResult += row[left++] ^ row[right--];
        for (int col = 0; col < colSize; col++)
            for (int up = 0, down = rowSize - 1; up < down; )
                colResult += grid[up++][col] ^ grid[down--][col];
        return Math.min(rowResult, colResult);
    }

}
