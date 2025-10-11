package matrix.workingPeoplesImitation.task_2906_Construct_Product_Matrix;

// my solution (refactored)
public class Solution {
    private static final int MODULO = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        long[][] prefixProduct = buildPrefixMatrix(grid);
        long[][] suffixProduct = buildSuffixMatrix(grid);
        long[] prefixRowProduct = buildPrefixArray(prefixProduct);
        long[] suffixRowProduct = buildSuffixArray(prefixProduct);

        int n = grid.length;
        int m = grid[0].length;

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long prefRowProd = i == 0 ? 1 : prefixRowProduct[i - 1];
                long sufRowProd = i == n - 1 ? 1 : suffixRowProduct[i + 1];
                long prefProd = j == 0 ? 1 : prefixProduct[i][j - 1];
                long sufProd = j == m - 1 ? 1 : suffixProduct[i][j + 1];

                long value = prefProd * sufProd * prefRowProd;
                value %= MODULO;
                value *= sufRowProd;
                matrix[i][j] = (int) value % MODULO;
            }
        }
        return matrix;
    }

    private long[][] buildPrefixMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[][] prefixProduct = new long[n][m];
        for (int i = 0; i < n; i++) {
            prefixProduct[i][0] = grid[i][0] % MODULO;
            for (int j = 1; j < m; j++) {
                prefixProduct[i][j] = grid[i][j] * prefixProduct[i][j - 1] % MODULO;
            }
        }
        return prefixProduct;
    }

    private long[][] buildSuffixMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[][] suffixProduct = new long[n][m];
        for (int i = 0; i < n; i++) {
            suffixProduct[i][m - 1] = grid[i][m - 1] % MODULO;
            for (int j = m - 2; j >= 0; j--) {
                suffixProduct[i][j] = suffixProduct[i][j + 1] * grid[i][j] % MODULO;
            }
        }
        return suffixProduct;
    }

    private long[] buildPrefixArray(long[][] prefixes) {
        int n = prefixes.length;
        int m = prefixes[0].length;
        long[] prefixRowProduct = new long[n];
        prefixRowProduct[0] = prefixes[0][m - 1];
        for (int i = 1; i < n; i++) {
            prefixRowProduct[i] = prefixRowProduct[i - 1] * prefixes[i][m - 1] % MODULO;
        }
        return prefixRowProduct;
    }

    private long[] buildSuffixArray(long[][] prefixes) {
        int n = prefixes.length;
        int m = prefixes[0].length;
        long[] suffixRowProduct = new long[n];
        suffixRowProduct[n - 1] = prefixes[n - 1][m - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixRowProduct[i] = suffixRowProduct[i + 1] * prefixes[i][m - 1] % MODULO;
        }
        return suffixRowProduct;
    }
}
