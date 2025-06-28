package matrix.workingPeoplesImitation.task_3160_Find_the_Number_of_Distinct_Colors_Among_the_Balls;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// my solution
public class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        Map<Integer, Integer> colorMap = new HashMap<>();
        Map<Integer, Integer> ballMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            int prevColor = ballMap.getOrDefault(ball, -1);
            if (prevColor >= 0) {
                colorMap.merge(prevColor, -1, Integer::sum);
            }
            colorMap.remove(prevColor, 0);
            ballMap.put(ball, color);
            colorMap.merge(color, 1, Integer::sum);
            ans[i] = colorMap.size();
        }
        return ans;
    }

    public int[] queryResults0(int limit, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        Map<Integer, Set<Integer>> colorBallsMap = new HashMap<>();
        Map<Integer, Integer> ballColorMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            int prevColor = ballColorMap.getOrDefault(ball, -1);
            Set<Integer> ballSet = colorBallsMap.getOrDefault(prevColor, new HashSet<>());
            ballSet.remove(ball);
            if (ballSet.isEmpty()) {
                colorBallsMap.remove(prevColor);
            }
            ballColorMap.put(ball, color);
            colorBallsMap.computeIfAbsent(color, set -> new HashSet<>()).add(ball);
            ans[i] = colorBallsMap.size();
        }
        return ans;
    }
}
