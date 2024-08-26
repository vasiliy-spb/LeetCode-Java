package matrix.workingPeoplesImitation.task_1391_Check_if_There_is_a_Valid_Path_in_a_Grid;

// from leetcode code sample (4)
public class Solution6 {
    static int d[][]; // to traverse 4 directions
    static int dir[][]; // to know if there is valid route to any of 4 directions from current cell
    public boolean hasValidPath(int[][] grid) {

        d = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        dir =   new int[][]{
                {1,0,1,0},
                {0,1,0,1},
                {1,0,0,1},
                {0,0,1,1},
                {1,1,0,0},
                {0,1,1,0}
        };
        return helper(grid,0,0);
    }
    public boolean helper(int grid[][],int x,int y){
        if(x==grid.length-1 && y==grid[0].length-1)
            return true;

        int curr = grid[x][y];
        grid[x][y] = -1; // to avoid loops
        for(int i=0;i<4;i++){
            int dx = x + d[i][0]; // new row co-ordinate
            int dy = y + d[i][1]; // new col co-ordinate
            if(dx>=0 && dx<grid.length && dy>=0 && dy<grid[0].length && grid[dx][dy]!=-1){
                // if there is a route from curr cell to next cell
                if(dir[curr-1][i] == dir[grid[dx][dy]-1][(i+2)%4] && dir[curr-1][i] == 1){
                    if(helper(grid,dx,dy))
                        return true;
                }
            }
        }
        return false;
    }
}
