package matrix.workingPeoplesImitation.task_986_Interval_List_Intersections;

import java.util.ArrayList;
import java.util.List;

// my solution
public class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersections = new ArrayList<>();
        int firstIndex = 0;
        int secondIndex = 0;
        while (firstIndex < firstList.length && secondIndex < secondList.length) {
            int firstStart = firstList[firstIndex][0];
            int firstEnd = firstList[firstIndex][1];
            int secondStart = secondList[secondIndex][0];
            int secondEnd = secondList[secondIndex][1];
            if (firstStart > secondEnd) {
                secondIndex++;
            } else if (secondStart > firstEnd) {
                firstIndex++;
            } else {
                intersections.add(new int[]{
                        Math.max(firstStart, secondStart),
                        Math.min(firstEnd, secondEnd)
                });
                if (firstEnd < secondEnd) {
                    firstIndex++;
                } else {
                    secondIndex++;
                }
            }
        }
        int[][] ans = new int[intersections.size()][];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = intersections.get(i);
        }
        return ans;
    }
}
