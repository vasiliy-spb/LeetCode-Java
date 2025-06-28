package matrix.workingPeoplesImitation.task_1901_Find_a_Peak_Element_II;

// my solution (time complexity: O(Math.max(m * log(n), n * log(m))
public class Solution2 {
    public int[] findPeakGrid(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int index = findPeak(mat, i);
            if (i > 0 && i < mat.length - 1) {
                if (row[index] > mat[i - 1][index] && row[index] > mat[i + 1][index]) {
                    return new int[]{i, index};
                }
            } else if (i > 0) {
                if (row[index] > mat[i - 1][index]) {
                    return new int[]{i, index};
                }
            } else if (i < mat.length - 1) {
                if (row[index] > mat[i + 1][index]) {
                    return new int[]{i, index};
                }
            } else {
                return new int[]{i, index};
            }
        }
        int[][] reversedMat = reverseMatrix(mat);
        for (int i = 0; i < reversedMat.length; i++) {
            int[] row = reversedMat[i];
            int index = findPeak(reversedMat, i);
            if (i > 0 && i < reversedMat.length - 1) {
                if (row[index] > reversedMat[i - 1][index] && row[index] > reversedMat[i + 1][index]) {
                    return new int[]{i, index};
                }
            } else if (i > 0) {
                if (row[index] > reversedMat[i - 1][index]) {
                    return new int[]{i, index};
                }
            } else if (i < reversedMat.length - 1) {
                if (row[index] > reversedMat[i + 1][index]) {
                    return new int[]{i, index};
                }
            } else {
                return new int[]{i, index};
            }
        }
        return new int[]{-1, -1};
    }

    private int[][] reverseMatrix(int[][] mat) {
        int[][] reversedMat = new int[mat[0].length][mat.length];
        for (int i = 0; i < reversedMat.length; i++) {
            for (int j = 0; j < reversedMat[i].length; j++) {
                reversedMat[i][j] = mat[j][i];
            }
        }
        return reversedMat;
    }

    private int findPeak(int[][] mat, int r) {
        int[] row = mat[r];
        int left = 0;
        int right = row.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (row[middle] > row[middle + 1]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}
