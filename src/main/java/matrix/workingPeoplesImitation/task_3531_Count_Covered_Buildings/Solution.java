package matrix.workingPeoplesImitation.task_3531_Count_Covered_Buildings;

import java.util.HashMap;
import java.util.Map;

// my solution
public class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, Integer> minX = new HashMap<>();
        Map<Integer, Integer> maxX = new HashMap<>();
        Map<Integer, Integer> minY = new HashMap<>();
        Map<Integer, Integer> maxY = new HashMap<>();
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            minX.merge(y, x, Integer::min);
            maxX.merge(y, x, Integer::max);
            minY.merge(x, y, Integer::min);
            maxY.merge(x, y, Integer::max);
        }
        int ans = 0;
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            if (minX.get(y) >= x) {
                continue;
            }
            if (maxX.get(y) <= x) {
                continue;
            }
            if (minY.get(x) >= y) {
                continue;
            }
            if (maxY.get(x) <= y) {
                continue;
            }
            ans++;
        }
        return ans;
    }
}
