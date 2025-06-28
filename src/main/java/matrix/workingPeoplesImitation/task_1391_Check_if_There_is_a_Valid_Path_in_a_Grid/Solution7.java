package matrix.workingPeoplesImitation.task_1391_Check_if_There_is_a_Valid_Path_in_a_Grid;

import java.util.LinkedList;
import java.util.Queue;

// from leetcode code sample (5)
public class Solution7 {
    int[][][] dirs = {
            {{0,-1} , {0,1}} ,
            {{-1,0} , {1,0}} ,
            {{0,-1} , {1,0}} ,
            {{0,1} ,  {1,0}} ,
            {{0,-1} , {-1,0}} ,
            {{0,1} , {-1,0}}
    };
    private class Cell{
        int x;
        int y;
        public Cell(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(0,0));
        visited[0][0] = true;
        while(!queue.isEmpty()){
            Cell curr = queue.poll();
            int x = curr.x;
            int y = curr.y;
            for(int[] dir : dirs[grid[x][y] - 1]){
                int i = x + dir[0];
                int j = y + dir[1];
                if(isValid(i , j , m , n) && !visited[i][j]){
                    for(int[] backDir : dirs[grid[i][j] - 1]){
                        if(i + backDir[0] == x && j + backDir[1] == y){
                            visited[i][j] = true;
                            queue.offer(new Cell(i,j));
                        }
                    }
                }
            }
        }
        return visited[n-1][m-1];
    }
    private boolean isValid(int x , int y , int n , int m){
        return x >= 0 && x < m && y>= 0 && y < n;
    }
}
