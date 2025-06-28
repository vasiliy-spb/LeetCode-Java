package matrix.workingPeoplesImitation.task_1267_Count_Servers_that_Communicate;

public class Solution {
    public int countServers(int[][] grid) {
        int count = 0;
        int[] rowCount = new int[grid.length];
        int[] colCount = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                    count++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
                    count--;
                }
            }
        }
        return count;
    }
}
