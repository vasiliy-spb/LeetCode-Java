package matrix.workingPeoplesImitation.task_3025_Find_the_Number_of_Ways_to_Place_People_I;

import java.util.Arrays;

// my solution
public class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (p1, p2) -> {
            int compareY = Integer.compare(p2[1], p1[1]);
            if (compareY == 0) {
                return Integer.compare(p1[0], p2[0]);
            }
            return compareY;
        });
        int count = 0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            int[] point1 = points[i];
            second: for (int j = i + 1; j < n; j++) {
                int[] point2 = points[j];
                if (point1[1] < point2[1] || point1[0] > point2[0]) {
                    continue;
                }
                for (int k = i + 1; k < j; k++) {
                    int[] point3 = points[k];
                    if (point3[1] < point2[1]) {
                        break;
                    }
                    if (point3[1] <= point1[1] && point3[1] >= point2[1]
                            && point3[0] >= point1[0] && point3[0] <= point2[0]) {
                        continue second;
                    }
                }
                count++;
            }
        }
        return count;
    }
}
