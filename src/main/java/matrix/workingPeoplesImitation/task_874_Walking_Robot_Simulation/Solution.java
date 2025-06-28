package matrix.workingPeoplesImitation.task_874_Walking_Robot_Simulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// my solution
public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, Set<Integer>> obstaclesMap = new HashMap<>();
        for (int[] obstacle : obstacles) {
            obstaclesMap.computeIfAbsent(obstacle[0], set -> new HashSet<>()).add(obstacle[1]);
        }
        int[] distance = {0, 0};
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int indexDir = 0;
        int x = 0;
        int y = 0;
        for (int command : commands) {
            if (command == -1) {
                indexDir++;
                indexDir %= 4;
            } else if (command == -2) {
                indexDir += 3;
                indexDir %= 4;
            } else {
                while (command > 0 && !obstaclesMap.getOrDefault(x + dirs[indexDir][0], new HashSet<>()).contains(y + dirs[indexDir][1])) {
                    x += dirs[indexDir][0];
                    y += dirs[indexDir][1];
                    command--;
                }
            }
            refreshDistance(distance, x, y);
        }
        return distance[0] * distance[0] + distance[1] * distance[1];
    }

    private void refreshDistance(int[] distance, int x, int y) {
        int dx = Math.abs(distance[0]);
        int dy = Math.abs(distance[1]);
        x = Math.abs(x);
        y = Math.abs(y);
        if (dx * dx + dy * dy < x * x + y * y) {
            distance[0] = x;
            distance[1] = y;
        }
    }
}
