package matrix.workingPeoplesImitation.task_835_Image_Overlap;

// from leetcode code sample (5)
public class Solution7 {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int range = n - 1;
        int maxCount = 0;

        for (int iOffset = -range; iOffset <= range; iOffset++) {
            for (int jOffset = -range; jOffset <= range; jOffset++) {
                int count = 0;
                for (int i = Math.max(iOffset, 0); i < Math.min(n, iOffset + n); i++) {
                    for (int j = Math.max(jOffset, 0); j < Math.min(n, jOffset + n); j++) {
                        int pixel1 = img1[i - iOffset][j - jOffset];
                        int pixel2 = img2[i][j];
                        if ((pixel1 + pixel2) == 2) {
                            count++;
                        }
                    }
                }
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}
