package matrix.workingPeoplesImitation.task_223_Rectangle_Area;

// my solution
public class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        return getRectangleArea(ax1, ax2, ay1, ay2)
                + getRectangleArea(bx1, bx2, by1, by2)
                - getIntersectArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
    }
    private int getIntersectArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int height = getCommonEdge(ay2, ay1, by2, by1);
        int width = getCommonEdge(ax2, ax1, bx2, bx1);
        return height * width;
    }
    private int getCommonEdge(int a, int b, int c, int d) {
        if (a < c) {
            return getCommonEdge(c, d, a, b);
        }
        if (c < b) {
            return 0;
        }
        return Math.abs(c - Math.max(b, d));
    }
    private int getRectangleArea(int x1, int x2, int y1, int y2) {
        return Math.abs(x1 - x2) * Math.abs(y1 - y2);
    }
}
