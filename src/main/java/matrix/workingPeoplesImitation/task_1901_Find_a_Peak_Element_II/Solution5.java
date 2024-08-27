package matrix.workingPeoplesImitation.task_1901_Find_a_Peak_Element_II;

// from leetcode code sample (2)
public class Solution5 {
    public int[] findPeakGrid(int[][] mat) {
        int low = 0;
        int high = mat[0].length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Find the maximum element in the current column
            int maxRow = 0;
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }

            // Check if the max element is a peak
            boolean leftIsSmaller = (mid == 0) || (mat[maxRow][mid] > mat[maxRow][mid - 1]);
            boolean rightIsSmaller = (mid == mat[0].length - 1) || (mat[maxRow][mid] > mat[maxRow][mid + 1]);

            if (leftIsSmaller && rightIsSmaller) {
                return new int[]{maxRow, mid};
            } else if (!leftIsSmaller) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1}; // Just in case, though a peak should always exist.
    }
}

