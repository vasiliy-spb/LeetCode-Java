package matrix.workingPeoplesImitation.task_3446_Sort_Matrix_by_Diagonals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// my solution
public class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int x = n - 1;
        int y = 0;

        while (y < n) {
            List<Integer> diagonal = new ArrayList<>();
            for (int i = y, j = x; i < n && j < n; i++, j++) {
                diagonal.add(grid[i][j]);
            }

            if (x == 0) {
                diagonal.sort(Comparator.reverseOrder());
            } else {
                diagonal.sort(Comparator.naturalOrder());
            }

            for (int i = y, j = x, d = 0; i < n && j < n; i++, j++, d++) {
                grid[i][j] = diagonal.get(d);
            }

            if (x > 0) {
                x--;
            } else {
                y++;
            }
        }
        return grid;
    }
}
