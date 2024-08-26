package matrix.workingPeoplesImitation.task_1391_Check_if_There_is_a_Valid_Path_in_a_Grid;

// from leetcode code sample (1)
public class Solution3 {
    int m, n;
    int[][] grid,
            dir = new int[][] { {0,0},{1,0},{0,-1},{-1,0},{0,1} },
            startMatrix = new int[][] { {0,0,0},{4,0,1},{1,1,0},{1,1,0},{4,0,1},{-1,0,0},{4,0,1} },
            decisionMatrix = new int[][] { {-1,-1,-1,-1,-1},{-1,-1,2,-1,4},{-1,1,-1,3,-1},{-1,-1,-1,2,1},{-1,-1,1,4,-1},{-1,2,-1,-1,3},{-1,4,3,-1,-1} };

    public boolean hasValidPath(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        if(m*n == 1) return true;
        int start = grid[0][0], next = startMatrix[start][0], i = startMatrix[start][1], j = startMatrix[start][2];
        if(dewIt(next, i, j)) return true;
        return (start == 4 && dewIt(1, 1, 0));
    }

    private boolean dewIt(int enter, int i, int j) {
        boolean[] seen = new boolean[n*m];
        while(enter != -1) {
            int k = i*n+j;
            if(!(i > -1 && j > -1 && i < m && j < n) || seen[k]) break;
            else seen[k] = true;
            enter =  decisionMatrix[grid[i][j]][enter];
            if(enter == -1) break;
            else if(i == m-1 && j == n-1) return true;
            i += dir[enter][0];
            j += dir[enter][1];
        }
        return false;
    }
}
