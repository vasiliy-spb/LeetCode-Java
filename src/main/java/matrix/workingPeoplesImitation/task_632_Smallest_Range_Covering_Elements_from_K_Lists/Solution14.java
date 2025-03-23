package matrix.workingPeoplesImitation.task_632_Smallest_Range_Covering_Elements_from_K_Lists;

import java.util.List;
import java.util.PriorityQueue;

// from leetcode code sample (9)
public class Solution14 {
    public int[] smallestRange(List<List<Integer>> nums) {

        int max = Integer.MIN_VALUE;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();

        int len = nums.size();
        for (int i = 0; i < len; i++) {
            int val = nums.get(i).get(0);

            minHeap.offer(new Pair(i, 0, val));

            max = Math.max(max, val);
        }

        // This is the first range.
        int leftRange = minHeap.peek().value;
        int rightRange = max;

        while (!minHeap.isEmpty()) {
            Pair minPair = minHeap.poll();
            int minValue = minPair.value;
            int listNum = minPair.listNo;
            int index = minPair.index;

            if (max - minValue < rightRange - leftRange) {
                leftRange = minValue;
                rightRange = max;
            }

            // Take out min, and move one position ahead.
            if (index + 1 < nums.get(listNum).size()) { // We still have some element left in the listNum list.
                index = index + 1;
                int val = nums.get(listNum).get(index);

                minHeap.offer(new Pair(listNum, index, val));

                // Look : All elements were smaller than this Max element.
                // So, all will still be smaller. But may be this element become greater than max.
                max = Math.max(max, val);
            } else {
                // We will have to break as one of the list ended.
                break;
            }

        }

        return new int[]{leftRange, rightRange};
    }


    private class Pair implements Comparable<Pair> {
        int listNo;
        int index;
        int value;

        public Pair(int listNo, int index, int value) {
            this.listNo = listNo;
            this.index = index;
            this.value = value;
        }

        public int compareTo(Pair that) {
            return this.value - that.value;
        }
    }
}
