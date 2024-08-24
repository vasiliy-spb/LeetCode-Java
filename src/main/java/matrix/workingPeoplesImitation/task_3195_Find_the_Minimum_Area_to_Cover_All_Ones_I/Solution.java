package matrix.workingPeoplesImitation.task_3195_Find_the_Minimum_Area_to_Cover_All_Ones_I;

public class Solution {
    public int minimumArea(int[][] grid) {
        int top = -1;
        int bottom = -1;
        int left = -1;
        int right = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (top < 0) {
                        top = i;
                    }
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                    if (left < 0) {
                        left = j;
                    }
                    left = Math.min(left, j);
                    right = Math.max(right, j);;
                }
            }
        }
        return (Math.abs(top - bottom) + 1) * (Math.abs(left - right) + 1);
    }
}
