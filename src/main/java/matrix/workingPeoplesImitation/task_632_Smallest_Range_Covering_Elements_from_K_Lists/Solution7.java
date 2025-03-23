package matrix.workingPeoplesImitation.task_632_Smallest_Range_Covering_Elements_from_K_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// from leetcode code sample (2)
public class Solution7 {
    static class Element {
        int val;
        int row;
        int col;

        public Element(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int[] currentElements = new int[n];
        int[] bestElements = new int[n];
        int currentMax = Integer.MIN_VALUE;
        int minRange = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = nums.get(i).get(0);
            pq.add(new Element(num, i, 0));
            currentElements[i] = num;
            currentMax = Math.max(num, currentMax);
        }

        while (!pq.isEmpty()) {
            Element next = pq.poll();
            int current = next.val;
            if (currentMax - current < minRange) {
                minRange = currentMax - current;

                for (int i = 0; i < n; i++) {
                    bestElements[i] = currentElements[i];
                }
            }

            int row = next.row;
            int nextCol = next.col + 1;
            if (nextCol < nums.get(row).size()) {
                int nextValue = nums.get(row).get(nextCol);
                pq.add(new Element(nextValue, row, nextCol));
                currentMax = Math.max(nextValue, currentMax);
                currentElements[row] = nextValue;
            } else {
                break;
            }

        }
        Arrays.sort(bestElements);
        int[] returning = new int[2];
        returning[1] = bestElements[n - 1];
        returning[0] = bestElements[0];
        return returning;
    }
}
