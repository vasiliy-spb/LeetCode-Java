package matrix.workingPeoplesImitation.task_3740_Minimum_Distance_Between_Three_Equal_Elements_I.task_3740_Minimum_Distance_Between_Three_Equal_Elements_I;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// my solution
public class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.computeIfAbsent(nums[i], num -> new ArrayList<>()).add(i);
        }

        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : indexMap.entrySet()) {
            List<Integer> indexes = entry.getValue();
            if (indexes.size() < 3) {
                continue;
            }
            int size = indexes.size();
            for (int i = 0; i < size - 2; i++) {
                int a = indexes.get(i);
                int b = indexes.get(i + 1);
                int c = indexes.get(i + 2);

                int currentSum = b - a + c - b + c - a;
                if (currentSum < min) {
                    min = currentSum;
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
