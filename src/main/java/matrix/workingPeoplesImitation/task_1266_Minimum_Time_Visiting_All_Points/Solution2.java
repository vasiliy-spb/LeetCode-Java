package matrix.workingPeoplesImitation.task_1266_Minimum_Time_Visiting_All_Points;

// my solution
public class Solution2 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for (int i = 1; i < points.length; i++) {
            time += Math.max(
                    Math.abs(points[i][0] - points[i - 1][0]),
                    Math.abs(points[i][1] - points[i - 1][1])
            );
        }
        return time;
    }
}
