package matrix.workingPeoplesImitation.task_835_Image_Overlap;

// my solution
public class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int maxOverlap = calculateMaxOverlapWithOffset(img1, img2);
        maxOverlap = Math.max(maxOverlap, calculateMaxOverlapWithOffset(img2, img1));
        rotateImage(img1);
        rotateImage(img2);
        maxOverlap = Math.max(maxOverlap, calculateMaxOverlapWithOffset(img1, img2));
        maxOverlap = Math.max(maxOverlap, calculateMaxOverlapWithOffset(img2, img1));
        return maxOverlap;
    }

    private void rotateImage(int[][] img) {
        int n = img.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[i][j] = img[i][n - j - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                img[i][j] = rotated[i][j];
            }
        }
    }

    private static int calculateMaxOverlapWithOffset(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;
        for (int offsetI = 0; offsetI < n; offsetI++) {
            for (int offsetJ = 0; offsetJ < n; offsetJ++) {
                int countOverlap = 0;
                for (int i = 0; i + offsetI < n; i++) {
                    for (int j = 0; j + offsetJ < n; j++) {
                        if (img2[i][j] == 1 && img1[i + offsetI][j + offsetJ] == 1) {
                            countOverlap++;
                        }
                    }
                }
                maxOverlap = Math.max(maxOverlap, countOverlap);
            }
        }
        return maxOverlap;
    }
}
