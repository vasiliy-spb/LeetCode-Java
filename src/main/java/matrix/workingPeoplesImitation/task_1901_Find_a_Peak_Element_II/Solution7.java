package matrix.workingPeoplesImitation.task_1901_Find_a_Peak_Element_II;

// from leetcode code sample (4)
public class Solution7 {
    public int findmax(int[][] mat, int mid) {
        int row = -1;
        int max = -1;
        for (int i = 0; i < mat.length; i++) {
            if (max < mat[i][mid]) {
                row = i;
                max = mat[i][mid];
            }
        }
        return row;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat[0].length - 1;
        int low = 0, high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = findmax(mat, mid);

            int left = (mid > 0) ? mat[row][mid - 1] : Integer.MIN_VALUE;
            int right = (mid < n) ? mat[row][mid + 1] : Integer.MIN_VALUE;

            if (mat[row][mid] > left && mat[row][mid] > right) {
                return new int[] { row, mid };
            }
            if (mat[row][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[] { -1, -1 };
    }
}

