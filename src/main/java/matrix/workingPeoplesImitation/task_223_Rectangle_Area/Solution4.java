package matrix.workingPeoplesImitation.task_223_Rectangle_Area;

// from leetcode code sample (2)
public class Solution4 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        int xmin = Math.min(ax2, bx2);
        int xmax = Math.max(ax1, bx1);
        int ymin = Math.min(ay2, by2);
        int ymax = Math.max(ay1, by1);
        int xdiff = xmin - xmax;
        int ydiff = ymin - ymax;
        int area3 = xdiff * ydiff;
        if (xdiff < 0 || ydiff < 0)
            area3 = 0;
        return area1 + area2 - area3;
    }
}
