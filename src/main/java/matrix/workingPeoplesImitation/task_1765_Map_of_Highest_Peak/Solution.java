package matrix.workingPeoplesImitation.task_1765_Map_of_Highest_Peak;

import matrix.workingPeoplesImitation.utils.Pair;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {

    // my solution
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    isWater[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    isWater[i][j] = -1;
                }
            }
        }
        int value = 1;
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] ceil = queue.poll();
                for (int[] dir : dirs) {
                    int y = ceil[0] + dir[0];
                    int x = ceil[1] + dir[1];
                    if (x < 0 || y < 0 || x >= isWater[0].length || y >= isWater.length) {
                        continue;
                    }
                    if (isWater[y][x] < 0) {
                        isWater[y][x] = value;
                        queue.offer(new int[]{y, x});
                    }
                }
            }
            value++;
        }
        return isWater;
    }

    // from walkccc.me
    public int[][] highestPeak2(int[][] isWater) {
        final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        final int m = isWater.length;
        final int n = isWater[0].length;
        int[][] ans = new int[m][n];
        Arrays.stream(ans).forEach(A -> Arrays.fill(A, -1));
        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (isWater[i][j] == 1) {
                    q.offer(new Pair<>(i, j));
                    ans[i][j] = 0;
                }

        while (!q.isEmpty()) {
            final int i = q.peek().getKey();
            final int j = q.poll().getValue();
            for (int[] dir : dirs) {
                final int x = i + dir[0];
                final int y = j + dir[1];
                if (x < 0 || x == m || y < 0 || y == n)
                    continue;
                if (ans[x][y] != -1)
                    continue;
                ans[x][y] = ans[i][j] + 1;
                q.offer(new Pair<>(x, y));
            }
        }

        return ans;
    }
}
