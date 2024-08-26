package matrix.workingPeoplesImitation.task_1391_Check_if_There_is_a_Valid_Path_in_a_Grid;

// from leetcode code sample (3)
public class Solution5 {
    public boolean hasValidPath(int[][] grid) {
        int[][][] dirs = {
                {{},{}},
                {{0,-1},{0,1}},
                {{-1,0},{1,0}},
                {{0,-1},{1,0}},
                {{0,1},{1,0}},
                {{0,-1},{-1,0}},
                {{0,1},{-1,0}}
        };
        int r = grid.length, c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        return dfs(grid, r, c, dirs, visited, 0, 0);
    }

    boolean dfs(int[][] g, int r, int c, int[][][] dirs, boolean[][] v, int x, int y) {
        if(x==r-1 && y==c-1) {
            return true;
        }

        v[x][y] = true;
        for(int[] d : dirs[g[x][y]]) {
            int nx = x + d[0];
            int ny = y + d[1];

            if(nx>=0 && nx<r && ny>=0 && ny<c && !v[nx][ny]) {
                for(int[] nd : dirs[g[nx][ny]]) {
                    if(nd[0]+nx==x && nd[1]+ny==y) {
                        if(dfs(g,r,c,dirs,v,nx,ny)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
