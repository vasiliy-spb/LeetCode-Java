package matrix.workingPeoplesImitation.task_1091_Shortest_Path_in_Binary_Matrix;

import java.util.LinkedList;
import java.util.Queue;

// from leetcode code sample (3)
public class Solution5 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        grid[0][0] = 1;
        for(int steps = 1;!queue.isEmpty();steps++)
        {
            int size = queue.size();
            for(int k=0; k<size; k++)
            {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                if(x == n-1 && y == n-1) return steps;

                for(int i = x-1; i<=x+1; i++)
                {
                    for(int j=y-1; j<=y+1; j++)
                    {
                        if(i>=0 && i<n && j >= 0 && j<n && grid[i][j] == 0 )
                        {
                            queue.add(new int[]{i,j});
                            grid[i][j] = 1;
                        }
                    }
                }
            }
        }
        return -1;
    }

}
