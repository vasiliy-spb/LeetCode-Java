package matrix.workingPeoplesImitation.task_54_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // my solution
    public List<Integer> spiralOrder0(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();
        while (top <= bottom || left <= right) {
            int x = left;
            int y = top;
            while (x <= right) {
                result.add(matrix[y][x]);
                x++;
            }
            if (top < bottom) top++;
            else break;
            y = top;
            x = right;
            while (y <= bottom) {
                result.add(matrix[y][x]);
                y++;
            }
            if (left < right) right--;
            else break;
            x = right;
            y = bottom;
            while (x >= left) {
                result.add(matrix[y][x]);
                x--;
            }
            if (top < bottom) bottom--;
            else break;
            y = bottom;
            x = left;
            while (y >= top) {
                result.add(matrix[y][x]);
                y--;
            }
            if (left < right) left++;
            else break;
        }
        return result;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();
        while (top <= bottom || left <= right) {
            int x = left;
            int y = top;
            while (x <= right)
                result.add(matrix[y][x++]);
            if (top < bottom) top++;
            else break;

            y = top;
            x = right;
            while (y <= bottom)
                result.add(matrix[y++][x]);
            if (left < right) right--;
            else break;

            x = right;
            y = bottom;
            while (x >= left)
                result.add(matrix[y][x--]);
            if (top < bottom) bottom--;
            else break;

            y = bottom;
            x = left;
            while (y >= top)
                result.add(matrix[y--][x]);
            if (left < right) left++;
            else break;
        }
        return result;
    }

    // from walkccc.me
    public List<Integer> spiralOrder2(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<>();

        final int m = matrix.length;
        final int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int r1 = 0;
        int c1 = 0;
        int r2 = m - 1;
        int c2 = n - 1;

        // Repeatedly add matrix[r1..r2][c1..c2] to `ans`.
        while (ans.size() < m * n) {
            for (int j = c1; j <= c2 && ans.size() < m * n; ++j)
                ans.add(matrix[r1][j]);
            for (int i = r1 + 1; i <= r2 - 1 && ans.size() < m * n; ++i)
                ans.add(matrix[i][c2]);
            for (int j = c2; j >= c1 && ans.size() < m * n; --j)
                ans.add(matrix[r2][j]);
            for (int i = r2 - 1; i >= r1 + 1 && ans.size() < m * n; --i)
                ans.add(matrix[i][c1]);
            ++r1;
            ++c1;
            --r2;
            --c2;
        }

        return ans;
    }
}
