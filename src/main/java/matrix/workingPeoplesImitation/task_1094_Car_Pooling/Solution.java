package matrix.workingPeoplesImitation.task_1094_Car_Pooling;

// my solution
public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] route = new int[1001];
        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];
            route[from] += passengers;
            route[to] -= passengers;
        }
        for (int i = 0; i < route.length; i++) {
            if (i > 0) {
                route[i] += route[i - 1];
            }
            if (route[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
