package matrix.workingPeoplesImitation.task_835_Image_Overlap;

// from leetcode code sample (2)
public class Solution4 {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int res = 0;
        int n = img1.length;
        var count = new int[n * 2][n * 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 0) continue;

                for (int m = 0; m < n; m++) {
                    for (int k = 0; k < n; k++) {
                        if (img2[m][k] == 0) continue;
                        res = Math.max(res, ++count[n + i - m][n + j - k]);
                    }
                }
            }
        }
        return res;
    }
}
