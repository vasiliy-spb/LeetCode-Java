package matrix.workingPeoplesImitation.task_3394_Check_if_Grid_can_be_Cut_into_Sections;

import java.util.Arrays;

// from leetcode code sample (2)
public class Solution5 {
    // // O(n log n) time complexity due to sorting
    // O(n) space complexity due to storing the rectangles
    //Java’s sorting algorithm (TimSort) takes O(n) auxiliary space in the worst case for merge operations.
    public boolean checkValidCuts(int n, int[][] rectangles) {
        // Edge case: Ensure the number of rectangles is valid
        if (rectangles.length < 3 || rectangles.length > 100000) {
            throw new IllegalArgumentException("Invalid number of rectangles");
        }

        // Check vertical (x-axis) and horizontal (y-axis) cuts
        return check(rectangles, 0, n) || check(rectangles, 1, n);
    }

    private boolean check(int[][] rectangles, int i, int n) {
        int res = 0;

        // Sort rectangles based on x1 (for vertical cut) or y1 (for horizontal cut)
        //Arrays.sort(rectangles, (a, b) -> a[i] - b[i]);
        Arrays.sort(rectangles, (a, b) -> a[i] - b[i]);

        int pre = rectangles[0][i + 2]; // Store the first rectangle's x2 or y2

        for (int[] r : rectangles) {
            // Edge case: Ensure the rectangle coordinates are within valid bounds
            if (r[0] < 0 || r[1] < 0 || r[2] > n || r[3] > n || r[0] >= r[2] || r[1] >= r[3]) {
                throw new IllegalArgumentException("Invalid rectangle coordinates");
            }

            // If there is a gap in x1 or y1 (depending on i), increment res
            if (pre <= r[i]) {
                res++;
            }

            // Update `pre` to track the furthest x2 or y2
            pre = Math.max(pre, r[i + 2]);
        }

        // If more than one valid cut exists, return true
        return res > 1;
    }
}
