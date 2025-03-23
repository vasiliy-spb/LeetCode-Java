package matrix.workingPeoplesImitation.task_632_Smallest_Range_Covering_Elements_from_K_Lists;

import java.util.List;
import java.util.PriorityQueue;

// from leetcode code sample (11)
public class Solution16 {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int currentMax = Integer.MIN_VALUE;
        int start = 0, end = Integer.MAX_VALUE;

        // Initialize the heap with the first element from each list and find the initial max
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[]{val, i, 0});
            currentMax = Math.max(currentMax, val);
        }

        // Process the heap
        while (minHeap.size() == nums.size()) {
            int[] current = minHeap.poll();
            int minVal = current[0];
            int listIdx = current[1];
            int eleIdx = current[2];

            // Update the smallest range if necessary
            if (currentMax - minVal < end - start || (currentMax - minVal == end - start && minVal < start)) {
                start = minVal;
                end = currentMax;
            }

            // If there's a next element in the same list, add it to the heap
            if (eleIdx + 1 < nums.get(listIdx).size()) {
                int nextVal = nums.get(listIdx).get(eleIdx + 1);
                minHeap.offer(new int[]{nextVal, listIdx, eleIdx + 1});
                currentMax = Math.max(currentMax, nextVal);
            } else {
                // One of the lists is exhausted, break the loop
                break;
            }
        }

        return new int[]{start, end};
    }
}
