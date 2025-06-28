package matrix.workingPeoplesImitation.task_1914_Cyclically_Rotating_a_Grid;


// from leetcode code sample (1)
public class Solution3 {
    public int[][] rotateGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int times = Math.min(n, m) / 2;
        for (int i = 1; i <= times; i++) {
            rotateShell(grid, i, k);
        }
        return grid;
    }


    public static void rotateShell(int[][] mat, int s, int r) {
        int oned[] = fillOnedFromShell(mat, s);
        rotate(oned, r);
        fillShellFromOned(mat, s, oned);
    }

    public static int[] fillOnedFromShell(int[][] mat, int s) {
        int maxR = mat.length - s;
        int maxC = mat[0].length - s;
        int minR = s - 1;
        int minC = s - 1;
        int size = 2 * (maxR - minR + maxC - minC);
        int oned[] = new int[size];
        int idx = 0;
        //left wall
        for (int i = minR, j = minC; i <= maxR; i++) {
            oned[idx++] = mat[i][j];
        }
        //bottom wall
        for (int i = maxR, j = minC + 1; j <= maxC; j++) {
            oned[idx++] = mat[i][j];
        }
        //right wall
        for (int i = maxR - 1, j = maxC; i >= minR; i--) {
            oned[idx++] = mat[i][j];
        }
        //top wall
        for (int i = minR, j = maxC - 1; j > minC; j--) {
            oned[idx++] = mat[i][j];
        }
        return oned;
    }

    public static void fillShellFromOned(int[][] mat, int s, int[] oned) {
        int maxR = mat.length - s;
        int maxC = mat[0].length - s;
        int minR = s - 1;
        int minC = s - 1;
        int size = 2 * (maxR - minR + maxC - minC);
        int idx = 0;
        //left wall
        for (int i = minR, j = minC; i <= maxR; i++) {
            mat[i][j] = oned[idx++];
        }
        //bottom wall
        for (int i = maxR, j = minC + 1; j <= maxC; j++) {
            mat[i][j] = oned[idx++];
        }
        //right wall
        for (int i = maxR - 1, j = maxC; i >= minR; i--) {
            mat[i][j] = oned[idx++];
        }
        //top wall
        for (int i = minR, j = maxC - 1; j > minC; j--) {
            mat[i][j] = oned[idx++];
        }
    }

    public static void rotate(int[] oned, int r) {
        int n = oned.length;
        r = r % n;
        if (r < 0) {
            r = n + r;
        }
        reverse(oned, 0, n - r - 1);
        reverse(oned, n - r, n - 1);
        reverse(oned, 0, n - 1);
    }

    public static void reverse(int oned[], int l, int r) {
        while (l < r) {
            int tmp = oned[l];
            oned[l] = oned[r];
            oned[r] = tmp;
            l++;
            r--;
        }
    }
}
