package matrix.workingPeoplesImitation.task_3394_Check_if_Grid_can_be_Cut_into_Sections;

import java.util.Arrays;

// from leetcode code sample (3)
public class Solution6 {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return sln1(n, rectangles);
    }

    private boolean sln1(int n, int[][] rect) {
        int m = rect.length;
        Arrays.sort(rect, (a, b) -> a[0] - b[0]);
        int count = 0;
        for (int i = 1, prev = rect[0][2]; i < m; i++) {
            if (prev <= rect[i][0]) count++;
            prev = Math.max(prev, rect[i][2]);
        }
        if (count >= 2) return true;

        Arrays.sort(rect, (a, b) -> a[1] - b[1]);
        count = 0;
        for (int i = 1, prev = rect[0][3]; i < m; i++) {
            if (prev <= rect[i][1]) count++;
            prev = Math.max(prev, rect[i][3]);
        }
        if (count >= 2) return true;
        return false;
    }
}
