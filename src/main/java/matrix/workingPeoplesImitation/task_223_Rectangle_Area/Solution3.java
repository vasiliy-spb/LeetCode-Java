package matrix.workingPeoplesImitation.task_223_Rectangle_Area;

// from leetcode code sample (1)
public class Solution3 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // Calculate the area of the first rectangle
        int area1 = (ax2 - ax1) * (ay2 - ay1);

        // Calculate the area of the second rectangle
        int area2 = (bx2 - bx1) * (by2 - by1);

        // Find the overlap along the x-axis
        int overlapX = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));

        // Find the overlap along the y-axis
        int overlapY = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));

        // Calculate the overlapping area
        int overlapArea = overlapX * overlapY;

        // Total area is the sum of both areas minus the overlapping area
        return area1 + area2 - overlapArea;
    }
}
