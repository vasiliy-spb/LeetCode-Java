package matrix.workingPeoplesImitation.task_547_Number_of_Provinces;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {

    // my solution
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int[] visited = new int[isConnected.length];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(isConnected[0]);
        while (Arrays.stream(visited).anyMatch(i -> i == 0)) {
            count++;
            for (int j = 0; j < visited.length; j++)
                if (visited[j] == 0) {
                    queue.offer(isConnected[j]);
                    break;
                }
            while (!queue.isEmpty()) {
                int[] currentConnected = queue.poll();
                for (int j = 0; j < currentConnected.length; j++) {
                    if (currentConnected[j] == 1 && visited[j] == 0) {
                        visited[j] |= currentConnected[j];
                        queue.offer(isConnected[j]);
                    }

                }
            }
        }
        return count;
    }
}
