package matrix.workingPeoplesImitation.task_1091_Shortest_Path_in_Binary_Matrix;

// from leetcode code sample (1)
// class Solution {
//   public int shortestPathBinaryMatrix(int[][] grid) {
//     final int n = grid.length;
//     if (grid[0][0] == 0 && n == 1)
//       return 1;
//     if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
//       return -1;

//     final int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

//     int ans = 0;
//     Queue<int[]> q = new ArrayDeque<>();
//     q.offer(new int[] {0, 0});
//     boolean[][] seen = new boolean[n][n];
//     seen[0][0] = true;

//     while (!q.isEmpty()) {
//       ++ans;
//       for (int sz = q.size(); sz > 0; --sz) {
//         final int i = q.peek()[0];
//         final int j = q.poll()[1];
//         for (int[] dir : dirs) {
//           final int x = i + dir[0];
//           final int y = j + dir[1];
//           if (x < 0 || x == n || y < 0 || y == n)
//             continue;
//           if (grid[x][y] != 0 || seen[x][y])
//             continue;
//           if (x == n - 1 && y == n - 1)
//             return ans + 1;
//           q.offer(new int[] {x, y});
//           seen[x][y] = true;
//         }
//       }
//     }

import java.util.ArrayDeque;

//     return -1;
//   }
// }
public class Solution3 {
    private record P(int y, int x)
    {
    }

    static class BfsRunner
    {
        final int end;
        final int[][] grid;
        final int mark;
        final int other;
        ArrayDeque<P> queue;

        BfsRunner(int[][] grid, int y, int x, int mark, int other)
        {
            this.grid = grid;
            this.end = grid.length - 1;
            this.mark = mark;
            this.other = other;
            queue = new ArrayDeque<>();
            queue.add(new P(y, x));
            grid[y][x] = mark;
        }

        boolean step()
        {
            for (int c = queue.size(); c > 0; --c)
            {
                final var p = queue.poll();
                final int yMin = Math.max(0, p.y() - 1);
                final int yMax = Math.min(end, p.y() + 1);
                final int xMin = Math.max(0, p.x() - 1);
                final int xMax = Math.min(end, p.x() + 1);

                for (int y = yMin; y <= yMax; ++y)
                {
                    for (int x = xMin; x <= xMax; ++x)
                    {
                        if (grid[y][x] != 0)
                        {
                            if (grid[y][x] == other)
                            {
                                return true;
                            }

                            continue;
                        }

                        queue.add(new P(y, x));
                        grid[y][x] = mark;
                    }
                }
            }

            return false;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid)
    {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid.length - 1] != 0)
        {
            return -1;
        }

        if (grid.length == 1)
        {
            return 1;
        }

        return bfs(grid);
    }



    private static int bfs(final int[][] grid)
    {
        final var fromStart = new BfsRunner(grid, 0, 0, 's', 'e');
        final var fromEnd = new BfsRunner(grid, grid.length - 1, grid.length - 1, 'e', 's');
        int steps = 1;

        while (!(fromStart.queue.isEmpty() || fromEnd.queue.isEmpty()))
        {
            ++steps;

            if (fromStart.step())
            {
                return steps;
            }

            ++steps;

            if (fromEnd.step())
            {
                return steps;
            }
        }

        return -1;
    }
}
