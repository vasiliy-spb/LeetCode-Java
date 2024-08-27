package matrix.workingPeoplesImitation.task_1901_Find_a_Peak_Element_II;

// my solution (time complexity: O(n * m))
public class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isPeak(mat, i, j)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean isPeak(int[][] mat, int i, int j) {
        for (int[] dir : dirs) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (y < 0 || x < 0 || y >= mat.length || x >= mat[0].length) {
                continue;
            }
            if (mat[i][j] < mat[y][x]) {
                return false;
            }
        }
        return true;
    }
}
