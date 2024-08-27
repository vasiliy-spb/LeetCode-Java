package matrix.workingPeoplesImitation.task_1901_Find_a_Peak_Element_II;

// from leetcode code sample (6)
public class Solution9 {
    public int[] findPeakGrid(int[][] mat) {
        int r = 0;
        int c = 0;

        while (r < mat.length || c < mat[0].length) {

            if ((c - 1 >= 0 && c - 1 < mat[0].length) && mat[r][c] < mat[r][c - 1]) {
                c--;
            } else if ((r + 1 >= 0 && r + 1 < mat.length) && mat[r][c] < mat[r + 1][c]) {
                r++;
            } else if ((r - 1 >= 0 && r - 1 < mat.length) && mat[r][c] < mat[r - 1][c]) {
                r--;
            } else if ((c + 1 >= 0 && c + 1 < mat[0].length) && mat[r][c] < mat[r][c + 1]) {
                c++;
            } else return new int[]{r, c};

        }
        return new int[]{-1, -1};
    }
}
