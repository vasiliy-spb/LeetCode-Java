package matrix.workingPeoplesImitation.task_1266_Minimum_Time_Visiting_All_Points;

// my solution
public class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        int x = points[0][0];
        int y = points[0][1];
        for (int[] point : points) {
            int currentX = point[0];
            int currentY = point[1];
            int maxDiff = Math.max(Math.abs(x - currentX), Math.abs(y - currentY));
            time += maxDiff;
            x = currentX;
            y = currentY;
        }
        return time;
    }
}
