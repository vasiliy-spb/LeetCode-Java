package matrix.workingPeoplesImitation.task_835_Image_Overlap;

// from leetcode code sample (4)
public class Solution6 {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int maxOverlap = 0;
        int sideLength = img1.length;
        int maxMove = sideLength - 1;
        for (int i = -maxMove; i <= maxMove; i++) {
            for (int j = -maxMove; j <= maxMove; j++) {
                int overlap = 0;
                int rowStart = Math.max(0, i);
                int rowEnd = Math.min(sideLength, sideLength + i);
                int columnStart = Math.max(0, j);
                int columnEnd = Math.min(sideLength, sideLength + j);
                for (int row = rowStart; row < rowEnd; row++) {
                    for (int column = columnStart; column < columnEnd; column++) {
                        if (img1[row][column] == 1 && img2[row - i][column - j] == 1)
                            overlap++;
                    }
                }
                maxOverlap = Math.max(maxOverlap, overlap);
            }
        }
        return maxOverlap;
    }
}
