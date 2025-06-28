package matrix.workingPeoplesImitation.task_3047_Find_the_Largest_Area_of_Square_Inside_Two_Rectangles;

// my solution
public class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long minEdge = 0;
        int n = bottomLeft.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int commonHeight = getCommonEdge(bottomLeft[i][0], topRight[i][0], bottomLeft[j][0], topRight[j][0]);
                int commonWidth = getCommonEdge(bottomLeft[i][1], topRight[i][1], bottomLeft[j][1], topRight[j][1]);
                if (commonWidth > 0 && commonHeight > 0) {
                    minEdge = Math.max(minEdge, Math.min(commonHeight, commonWidth));
                }
            }
        }
        return minEdge * minEdge;
    }

    private int getCommonEdge(int a, int b, int c, int d) {
        if (a < b) {
            return getCommonEdge(b, a, c, d);
        }
        if (c < d) {
            return getCommonEdge(a, b, d, c);
        }
        if (a < c) {
            return getCommonEdge(c, d, a, b);
        }
        if (c < b) {
            return 0;
        }
        return Math.abs(c - Math.max(b, d));
    }
}
