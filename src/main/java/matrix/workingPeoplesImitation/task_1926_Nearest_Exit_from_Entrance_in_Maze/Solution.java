package matrix.workingPeoplesImitation.task_1926_Nearest_Exit_from_Entrance_in_Maze;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {

    // my solution
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = 'v';
        int level = 0;
        one: while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] current = queue.poll();
                maze[current[0]][current[1]] = 'v';
                if ((current[0] != entrance[0] || current[1] != entrance[1]) &&
                        (current[0] - 1 < 0 || current[0] + 1 >= maze.length || current[1] - 1 < 0 || current[1] + 1 >= maze[0].length) )
                    return level;
                if (current[0] > 0 && maze[current[0] - 1][current[1]] == '.') {
                    maze[current[0] - 1][current[1]] = 'v';
                    queue.offer(new int[]{current[0] - 1, current[1]});
                }
                if (current[1] > 0 && maze[current[0]][current[1] - 1] == '.') {
                    maze[current[0]][current[1] - 1] = 'v';
                    queue.offer(new int[]{current[0], current[1] - 1});
                }
                if (current[0] < maze.length - 1 && maze[current[0] + 1][current[1]] == '.') {
                    maze[current[0] + 1][current[1]] = 'v';
                    queue.offer(new int[]{current[0] + 1, current[1]});
                }
                if (current[1] < maze[0].length - 1 && maze[current[0]][current[1] + 1] == '.') {
                    maze[current[0]][current[1] + 1] = 'v';
                    queue.offer(new int[]{current[0], current[1] + 1});
                }
            }
            level++;
        }
        return -1;
    }

    // from walkccc.me
    public int nearestExit2(char[][] maze, int[] entrance) {
        final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        final int m = maze.length;
        final int n = maze[0].length;
        int ans = 0;
        Queue<int[]> q = new ArrayDeque<>(Arrays.asList(new int[] {entrance[0], entrance[1]}));
        boolean[][] seen = new boolean[m][n];
        seen[entrance[0]][entrance[1]] = true;

        while (!q.isEmpty()) {
            ++ans;
            for (int sz = q.size(); sz > 0; --sz) {
                final int i = q.peek()[0];
                final int j = q.poll()[1];
                for (int[] dir : dirs) {
                    final int x = i + dir[0];
                    final int y = j + dir[1];
                    if (x < 0 || x == m || y < 0 || y == n)
                        continue;
                    if (seen[x][y] || maze[x][y] == '+')
                        continue;
                    if (x == 0 || x == m - 1 || y == 0 || y == n - 1)
                        return ans;
                    q.offer(new int[] {x, y});
                    seen[x][y] = true;
                }
            }
        }

        return -1;
    }

}
