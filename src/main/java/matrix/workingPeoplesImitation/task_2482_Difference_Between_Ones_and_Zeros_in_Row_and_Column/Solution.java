package matrix.workingPeoplesImitation.task_2482_Difference_Between_Ones_and_Zeros_in_Row_and_Column;

public class Solution {
    public static int[][] onesMinusZeros(int[][] grid) {
        int[][] diff = new int[grid.length][grid[0].length];
        int[] rows = new int[grid.length];
        int[] columns = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int currentEl = grid[i][j];
                if (currentEl == 1) {
                    rows[i] += 1;
                    columns[j] += 1;
                } else if (currentEl == 0) {
                    rows[i] -= 1;
                    columns[j] -= 1;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                diff[i][j] = rows[i] + columns[j];
            }
        }
        return diff;
    }


    public static void main(String[] args) {
        int[][] grid = {{0,1,1},{1,0,1},{0,0,1}};
        int[][] diff = onesMinusZeros(grid);
        for (int[] ints : diff) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}