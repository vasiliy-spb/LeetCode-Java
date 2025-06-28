package matrix.workingPeoplesImitation.task_3001_Minimum_Moves_to_Capture_The_Queen;

public class Solution {

    // my solution
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        int[][] dirs = new int[][]{{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
        if (Math.abs(c - e) == Math.abs(d - f)) {
            for (int[] dir : dirs) {
                int y = c;
                int x = d;
                while (y > 0 && y < 9 && x > 0 && x < 9) {
                    if (y == a && x == b) {
                        break;
                    }
                    if (y == e && x == f) {
                        return 1;
                    }
                    y += dir[0];
                    x += dir[1];
                }
            }
        }
        if (a == e) {
            if (a == c) {
                return d < b && d > f || d < f && d > b ? 2 : 1;
            } else {
                return 1;
            }
        }
        if (b == f) {
            if (b == d) {
                return c > a && c < e || c > e && c < a ? 2 : 1;
            } else {
                return 1;
            }
        }
        return 2;
    }

    // from walkccc.me
    public int minMovesToCaptureTheQueen2(int a, int b, int c, int d, int e, int f) {
        // The rook is in the same row as the queen.
        if (a == e)
            // The bishop blocks the rook or not.
            return (c == a && (b < d && d < f || b > d && d > f)) ? 2 : 1;
        // The rook is in the same column as the queen.
        if (b == f)
            // The bishop blocks the rook or not.
            return (d == f && (a < c && c < e || a > c && c > e)) ? 2 : 1;
        // The bishop is in the same up-diagonal as the queen.
        if (c + d == e + f)
            // The rook blocks the bishop or not.
            return (a + b == c + d && (c < a && a < e || c > a && a > e)) ? 2 : 1;
        // The bishop is in the same down-diagonal as the queen.
        if (c - d == e - f)
            // The rook blocks the bishop or not.
            return (a - b == c - d && (c < a && a < e || c > a && a > e)) ? 2 : 1;
        // The rook can always get the green in two steps.
        return 2;
    }

}
