package matrix.workingPeoplesImitation.task_1943_Describe_the_Painting;

import java.util.*;

// my solution
public class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        Map<Integer, Set<Integer>> lastIndexes = new HashMap<>();
        long[] prefixSum = new long[100001];
        for (int[] segment : segments) {
            int start = segment[0];
            int end = segment[1];
            int color = segment[2];
            lastIndexes.computeIfAbsent(end, set -> new HashSet<>()).add(color);
            prefixSum[start] += color;
            prefixSum[end] -= color;
        }
        int start = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            if (i > 0) {
                prefixSum[i] += prefixSum[i - 1];
            }
        }
        List<List<Long>> ans = new ArrayList<>();
        long prev = prefixSum[0];
        Set<Integer> prevColorSet = new HashSet<>();
        for (int i = 0; i < prefixSum.length; i++) {
            long color = prefixSum[i];
            if (prev != 0 && (color != prev || i == prefixSum.length - 1 || !prevColorSet.equals(lastIndexes.getOrDefault(i, prevColorSet)))) {
                ans.add(List.of((long) start, (long) i, prev));
                start = i;
                prevColorSet = lastIndexes.getOrDefault(i, prevColorSet);
            }
            if (color == 0) {
                start = i + 1;
            }
            prev = color;
        }
        return ans;
    }
}
