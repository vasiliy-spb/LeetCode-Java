package matrix.workingPeoplesImitation.task_1094_Car_Pooling;

import java.util.Map;
import java.util.TreeMap;

// from walkccc.me (Approach 1: Line Sweep)
public class Solution2 {
    public boolean carPooling(int[][] trips, int capacity) {
        int currentPassengers = 0;
        Map<Integer, Integer> line = new TreeMap<>();

        for (int[] trip : trips) {
            final int nPassengers = trip[0];
            final int start = trip[1];
            final int end = trip[2];
            line.merge(start, nPassengers, Integer::sum);
            line.merge(end, -nPassengers, Integer::sum);
        }

        for (final int passengerChange : line.values()) {
            currentPassengers += passengerChange;
            if (currentPassengers > capacity)
                return false;
        }

        return true;
    }
}
