package matrix.workingPeoplesImitation.task_885_Spiral_Matrix_III;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // my solution (fastest)
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int top = rStart;
        int bottom = rStart;
        int left = cStart;
        int right = cStart;
        int[][] arr = new int[rows * cols][];
        int index = 0;
        cols--;
        rows--;
        arr[index++] = new int[]{rStart, cStart};

        while (top >= 0 || bottom <= rows || left >= 0 || right <= cols) {
            right++;
            for (int r = left + 1; r <= right && r <= cols; r++)
                if (top >= 0 && top <= rows && r >= 0)
                    arr[index++] = new int[]{top, r};

            bottom++;
            for (int b = top + 1; b <= bottom && b <= rows; b++)
                if (b >= 0 && right >= 0 && right <= cols)
                    arr[index++] = new int[]{b, right};

            left--;
            for (int l = right - 1; l >= left && l >= 0; l--)
                if (l <= cols && bottom >= 0 && bottom <= rows)
                    arr[index++] = new int[]{bottom, l};

            top--;
            for (int t = bottom - 1; t >= top && t >= 0; t--)
                if (t <= rows && left >= 0 && left <= cols)
                    arr[index++] = new int[]{t, left};
        }

        return arr;
    }

    // my solution
    public int[][] spiralMatrixIII1(int rows, int cols, int rStart, int cStart) {
        int top = rStart;
        int bottom = rStart;
        int left = cStart;
        int right = cStart;
        int[][] arr = new int[rows * cols][2];
        int index = 0;
        cols--;
        rows--;
        arr[index++] = new int[]{rStart, cStart};

        while (top >= 0 || bottom <= rows || left >= 0 || right <= cols) {
            right++;
            for (int r = Math.max(0, left + 1); r <= right && r <= cols; r++)
                if (top >= 0 && top <= rows && r >= 0) {
                    arr[index][0] = top;
                    arr[index++][1] = r;
                }

            bottom++;
            for (int b = Math.max(0, top + 1); b <= bottom && b <= rows; b++)
                if (b >= 0 && right >= 0 && right <= cols) {
                    arr[index][0] = b;
                    arr[index++][1] = right;
                }

            left--;
            for (int l = Math.min(cols, right - 1); l >= left && l >= 0; l--)
                if (l <= cols && bottom >= 0 && bottom <= rows) {
                    arr[index][0] = bottom;
                    arr[index++][1] = l;
                }

            top--;
            for (int t = Math.min(rows, bottom - 1); t >= top && t >= 0; t--)
                if (t <= rows && left >= 0 && left <= cols) {
                    arr[index][0] = t;
                    arr[index++][1] = left;
                }
        }

        return arr;
    }

    // my solution
    public int[][] spiralMatrixIII2(int rows, int cols, int rStart, int cStart) {
        int top = rStart;
        int bottom = rStart;
        int left = cStart;
        int right = cStart;
        int[][] arr = new int[rows * cols][];
        int index = 0;
        cols--;
        rows--;
        arr[index++] = new int[]{rStart, cStart};

        while (top >= 0 || bottom <= rows || left >= 0 || right <= cols) {
            if (right < cols) right++;
            for (int r = Math.max(0, left + 1); r <= cols && r <= right; r++)
                if (top >= 0 && top <= rows && r >= 0 && r <= cols)
                    arr[index++] = new int[]{top, r};

            if (bottom < rows) bottom++;
            for (int b = Math.max(0, top + 1); b <= rows && b <= bottom; b++)
                if (b >= 0 && right >= 0 && right <= cols)
                    arr[index++] = new int[]{b, right};

            if (left > 0) left--;
            for (int l = Math.min(cols, right - 1); l >= 0 && l >= left; l--)
                if (l <= cols && bottom >= 0 && bottom <= rows)
                    arr[index++] = new int[]{bottom, l};

            if (top > 0) top--;
            for (int t = Math.min(rows, bottom - 1); t >= 0 && t >= top; t--)
                if (t <= rows && left >= 0 && left <= cols)
                    arr[index++] = new int[]{t, left};
        }

        return arr;
    }

    // my solution
    public int[][] spiralMatrixIII0(int rows, int cols, int rStart, int cStart) {
        int top = rStart;
        int bottom = rStart;
        int left = cStart;
        int right = cStart;
        int[][] arr = new int[rows][cols];
        int index = 0;
        cols--;
        rows--;
        List<int[]> coordinates = new ArrayList<>();
        coordinates.add(new int[]{rStart, cStart});


        while (top >= 0 || bottom <= rows || left >= 0 || right <= cols) {
            right++;
            for (int r = left + 1; r <= right && r <= cols; r++)
                if (top >= 0 && top <= rows && r >= 0 && r <= cols)
                    coordinates.add(new int[]{top, r});

            bottom++;
            for (int b = top + 1; b <= bottom && b <= rows; b++)
                if (b >= 0 && right >= 0 && right <= cols)
                    coordinates.add(new int[]{b, right});

            left--;
            for (int l = right - 1; l >= left && l >= 0; l--)
                if (l <= cols && bottom >= 0 && bottom <= rows)
                    coordinates.add(new int[]{bottom, l});

            top--;
            for (int t = bottom - 1; t >= top && t >= 0; t--)
                if (t <= rows && left >= 0 && left <= cols)
                    coordinates.add(new int[]{t, left});
        }

        int[][] result = new int[coordinates.size()][2];
        for (int i = 0; i < coordinates.size(); i++)
            result[i] = coordinates.get(i);
        return result;
    }

    // from walkccc.me
    public int[][] spiralMatrixIII4(int rows, int cols, int rStart, int cStart) {
        final int[] dx = {1, 0, -1, 0};
        final int[] dy = {0, 1, 0, -1};
        List<int[]> ans = new ArrayList<>(Arrays.asList(new int[] {rStart, cStart}));

        for (int i = 0; ans.size() < rows * cols; ++i)
            for (int step = 0; step < i / 2 + 1; ++step) {
                rStart += dy[i % 4];
                cStart += dx[i % 4];
                if (0 <= rStart && rStart < rows && 0 <= cStart && cStart < cols)
                    ans.add(new int[] {rStart, cStart});
            }

        return ans.stream().toArray(int[][] ::new);
    }
}
