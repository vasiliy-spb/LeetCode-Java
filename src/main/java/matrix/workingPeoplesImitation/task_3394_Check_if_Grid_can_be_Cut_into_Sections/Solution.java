package matrix.workingPeoplesImitation.task_3394_Check_if_Grid_can_be_Cut_into_Sections;

import java.util.*;

// my solution
public class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        Set<Integer> xSet = getCuts(rectangles, 0, 2);
        Set<Integer> ySet = getCuts(rectangles, 1, 3);
        return xSet.size() >= 2 || ySet.size() >= 2;
    }

    private Set<Integer> getCuts(int[][] rectangles, int startIndex, int endIndex) {
        Arrays.sort(rectangles, (a, b) -> a[endIndex] - b[endIndex]);
        List<Integer> tails = new ArrayList<>();
        int prevX = 0;
        for (int[] rectangle : rectangles) {
            while (hasOverlapWithLastRectangle(tails, rectangle[startIndex])) {
                tails.remove(tails.size() - 1);
            }
            if (rectangle[endIndex] >= prevX) {
                tails.add(rectangle[endIndex]);
            }
            prevX = rectangle[endIndex];
        }
        if (!tails.isEmpty()) {
            tails.remove(tails.size() - 1);
        }
        return new HashSet<>(tails);
    }

    private static boolean hasOverlapWithLastRectangle(List<Integer> tails, int currentTail) {
        return !tails.isEmpty() && tails.get(tails.size() - 1) > currentTail;
    }
}
