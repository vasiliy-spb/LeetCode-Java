package matrix.workingPeoplesImitation.task_1895_Largest_Magic_Square;

public class Solution {

    // my solution
    public int largestMagicSquare(int[][] grid) {
        int maxK = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int k = 2;
                while (grid.length - i >= k && grid[i].length - j >= k) {
                    if (isMagicSquare(grid, i, j, k)) {
                        maxK = Math.max(maxK, k);
                    }
                    k++;
                }
            }
        }
        return maxK;
    }

    private boolean isMagicSquare(int[][] grid, int i, int j, int k) {
        if (grid.length - i < k) {
            return false;
        }
        if (grid[i].length - j < k) {
            return false;
        }
        int[] rowSum = new int[k];
        int[] colSum = new int[k];
        for (int n = i, r = -n; n < i + k; n++) {
            for (int m = j, c = -m; m < j + k; m++) {
                rowSum[r + n] += grid[n][m];
                colSum[c + m] += grid[n][m];
            }
        }
        int aDiagonal = 0;
        int bDiagonal = 0;
        for (int d = 0; d < k; d++) {
            aDiagonal += grid[i + d][j + d];
            bDiagonal += grid[(i + (k - 1)) - d][j + d];
        }
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

    // from walkccc.me
    public int largestMagicSquare2(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        // prefixRow[i][j] := the sum of the first j numbers in the i-th row
        int[][] prefixRow = new int[m][n + 1];
        // prefixCol[i][j] := the sum of the first j numbers in the i-th column
        int[][] prefixCol = new int[n][m + 1];

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                prefixRow[i][j + 1] = prefixRow[i][j] + grid[i][j];
                prefixCol[j][i + 1] = prefixCol[j][i] + grid[i][j];
            }

        for (int k = Math.min(m, n); k >= 2; --k)
            if (containsMagicSquare(grid, prefixRow, prefixCol, k))
                return k;

        return 1;
    }

    // Returns true if the grid contains any magic square of size k x k.
    private boolean containsMagicSquare(int[][] grid, int[][] prefixRow, int[][] prefixCol, int k) {
        for (int i = 0; i + k - 1 < grid.length; ++i)
            for (int j = 0; j + k - 1 < grid[0].length; ++j)
                if (isMagicSquare(grid, prefixRow, prefixCol, i, j, k))
                    return true;
        return false;
    }

    // Returns true if grid[i..i + k)[j..j + k) is a magic square.
    private boolean isMagicSquare(int[][] grid, int[][] prefixRow, int[][] prefixCol, int i, int j,
                                  int k) {
        int diag = 0;
        int antiDiag = 0;
        for (int d = 0; d < k; ++d) {
            diag += grid[i + d][j + d];
            antiDiag += grid[i + d][j + k - 1 - d];
        }
        if (diag != antiDiag)
            return false;
        for (int d = 0; d < k; ++d) {
            if (getSum(prefixRow, i + d, j, j + k - 1) != diag)
                return false;
            if (getSum(prefixCol, j + d, i, i + k - 1) != diag)
                return false;
        }
        return true;
    }

    // Returns sum(grid[i][l..r]) or sum(grid[l..r][i]).
    private int getSum(int[][] prefix, int i, int l, int r) {
        return prefix[i][r + 1] - prefix[i][l];
    }

}
