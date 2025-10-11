package matrix.workingPeoplesImitation.task_2906_Construct_Product_Matrix;

// my solution (in one method)
public class Solution2 {
    public int[][] constructProductMatrix(int[][] grid) {
        int modulo = 12345;
        int n = grid.length;
        int m = grid[0].length;

        long[][] prefixProduct = new long[n][m];
        for (int i = 0; i < n; i++) {
            prefixProduct[i][0] = grid[i][0] % modulo;
            for (int j = 1; j < m; j++) {
                prefixProduct[i][j] = grid[i][j] * prefixProduct[i][j - 1] % modulo;
            }
        }

        long[][] suffixProduct = new long[n][m];
        for (int i = 0; i < n; i++) {
            suffixProduct[i][m - 1] = grid[i][m - 1] % modulo;
            for (int j = m - 2; j >= 0; j--) {
                suffixProduct[i][j] = suffixProduct[i][j + 1] * grid[i][j] % modulo;
            }
        }

        long[] prefixRowProduct = new long[n];
        prefixRowProduct[0] = prefixProduct[0][m - 1];
        for (int i = 1; i < n; i++) {
            prefixRowProduct[i] = prefixRowProduct[i - 1] * prefixProduct[i][m - 1] % modulo;
        }

        long[] suffixRowProduct = new long[n];
        suffixRowProduct[n - 1] = prefixProduct[n - 1][m - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixRowProduct[i] = suffixRowProduct[i + 1] * prefixProduct[i][m - 1] % modulo;
        }

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long prefRowProd = i == 0 ? 1 : prefixRowProduct[i - 1];
                long sufRowProd = i == n - 1 ? 1 : suffixRowProduct[i + 1];
                long prefProd = j == 0 ? 1 : prefixProduct[i][j - 1];
                long sufProd = j == m - 1 ? 1 : suffixProduct[i][j + 1];

                long value = prefProd * sufProd * prefRowProd;
                value %= modulo;
                value *= sufRowProd;
                matrix[i][j] = (int) value % modulo;
            }
        }
        return matrix;
    }
}
