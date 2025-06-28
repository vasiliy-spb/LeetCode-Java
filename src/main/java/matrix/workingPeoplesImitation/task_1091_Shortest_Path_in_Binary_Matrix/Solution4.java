package matrix.workingPeoplesImitation.task_1091_Shortest_Path_in_Binary_Matrix;

// from leetcode code sample (2)
public class Solution4 {
    // _ _ _ _
    // _ x x _
    // _ _ x _
    // _ _ _ _

    // _ _ _ _ _
    // x x x x _
    // _ _ _ _ _
    // _ x x x x
    // _ _ _ _ _

    public int shortestPathBinaryMatrix(final int[][] grid) {
        final int n = grid.length;
        final int n2 = n * n;
        final int m = n - 1;

        final boolean[] visited = new boolean[n2];
        visited[0] = true;

        final int[] queue = new int[n2];
        queue[0] = 0;
        int currQueueHead = 0;
        int currQueueTail = 1;
        int nextQueueTail = 1;

        for (int d = 1; currQueueHead != currQueueTail; ++d) {
            while (currQueueHead < currQueueTail) {
                final int i = queue[currQueueHead++];
                final int r = i / n;
                final int c = i % n;
                if (grid[r][c] == 1) continue;
                if (r == m && c == m) return d;

                // h:(r-1, c-1, i-n-1) g:(r-1,  c, i-n  ) e:(r-1, c+1, i-n+1)
                // f:(r  , c  , i  -1)                    c:(r  , c+1, i  +1)
                // d:(r+1, c+1, i+n-1) b:(r+1,  c, i+n  ) a:(r+1, c+1, i+n+1)
                final int rMin = Math.max(r - 1, 0);
                final int rMax = Math.min(r + 1, m);
                final int cMin = Math.max(c - 1, 0);
                final int cMax = Math.min(c + 1, m);
                for (int r0 = rMin; r0 <= rMax; ++r0) {
                    for (int c0 = cMin; c0 <= cMax; ++c0) {
                        final int i0 = r0 * n + c0;
                        if (visited[i0]) continue;
                        visited[i0] = true;
                        queue[nextQueueTail++] = i0;
                    }
                }
            }
            currQueueTail = nextQueueTail;
        }
        return -1;
    }
}
