package matrix.workingPeoplesImitation.task_835_Image_Overlap;

// from leetcode code sample (1)
public class Solution3 {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int[][] record = new int[2 * n][2 * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    for (int k = 0; k < n; k++) {
                        for (int q = 0; q < n; q++) {
                            if (img2[k][q] == 1) {
                                record[k - i + n][q - j + n] += 1;
                            }
                        }
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < record[0].length; j++) {
                max = Math.max(max, record[i][j]);
            }
        }
        return max;
    }
}
