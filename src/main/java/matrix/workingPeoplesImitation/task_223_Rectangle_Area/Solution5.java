package matrix.workingPeoplesImitation.task_223_Rectangle_Area;

// from leetcode code sample (3)
public class Solution5 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //find area of each rect and sub from overlapping area
        //area l and b
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);

        //to find overlap need to find the left and right
        //top and bottom
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int overlapx = right - left;

        int bottom = Math.max(ay1, by1);
        int top = Math.min(ay2, by2);
        int overlapy = top - bottom;

        int overalparea = 0;
        //if not neg x and y only then find overlap
        if (overlapx > 0 && overlapy > 0) {
            overalparea = overlapx * overlapy;
        }

        return area1 + area2 - overalparea;
    }
}
