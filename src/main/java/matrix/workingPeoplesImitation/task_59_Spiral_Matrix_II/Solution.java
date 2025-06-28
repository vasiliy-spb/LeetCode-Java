package matrix.workingPeoplesImitation.task_59_Spiral_Matrix_II;

public class Solution {

    // my solution
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int num = 1;
        while (top <= bottom || left <= right) {
            int x = left;
            int y = top;
            while (x <= right)
                matrix[y][x++] = num++;
            if (top < bottom) top++;
            else break;

            x = right;
            y = top;
            while (y <= bottom)
                matrix[y++][x] = num++;
            if (left < right) right--;
            else break;

            x = right;
            y = bottom;
            while (x >= left)
                matrix[y][x--] = num++;
            if (top < bottom) bottom--;
            else break;

            x = left;
            y = bottom;
            while (y >= top)
                matrix[y--][x] = num++;
            if (left < right) left++;
            else break;
        }
        return matrix;
    }

    // from walkccc.me
    public int[][] generateMatrix2(int n) {
        int[][] ans = new int[n][n];
        int count = 1;

        for (int min = 0; min < n / 2; ++min) {
            final int max = n - min - 1;
            for (int i = min; i < max; ++i)
                ans[min][i] = count++;
            for (int i = min; i < max; ++i)
                ans[i][max] = count++;
            for (int i = max; i > min; --i)
                ans[max][i] = count++;
            for (int i = max; i > min; --i)
                ans[i][min] = count++;
        }

        if (n % 2 == 1)
            ans[n / 2][n / 2] = count;

        return ans;
    }

}
