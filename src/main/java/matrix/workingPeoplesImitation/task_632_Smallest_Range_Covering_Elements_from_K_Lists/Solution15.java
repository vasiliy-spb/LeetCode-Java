package matrix.workingPeoplesImitation.task_632_Smallest_Range_Covering_Elements_from_K_Lists;

import java.util.List;
import java.util.PriorityQueue;

// from leetcode code sample (10)
public class Solution15 {
    /**
     * -> increasing order
     * [[4,10,15,24,26],
     * [0,9,12,20],
     * [5,18,22,30]]
     * <p>
     * 4, 10, 15,[24],26],
     * 0,  9, 12,[20]], <- it reach the end of the list.
     * 5, 18,[22],30]
     * <p>
     * maxVal = 24
     * minHeap = [[22,2,2],[24,0,3]]
     * val,index of list, index of element in the list.
     * <p>
     * diff  =  4
     * minDiff= 4
     * res=[20,24], update only when diff > minDiff.
     * <p>
     * from my observation, look like queue
     * we have keep it as decreasing order and only have k elements.
     * => minHeap such that we can keep remove our minValue from top.
     * -> maxVal ? use variable to keep max one when move to next element
     * <p>
     * heap<value, index in the list>
     * then we can know which list should move on to the next element.
     * -> if index reach to the end of list. we terminate it.
     * <p>
     * TC: O(klogk + min length of lists * logk )
     * SC: O(k)
     * <p>
     * [20,24]
     * [a, b] < [c, d]
     * 1. |a-b| < |c-d|
     * 2. |a-b| == |c-d|, a < c
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();

        /**
         [1,55]
         [-55,-1]
         ^
         */
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] res = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}; // minVal = res[1] - res[0]
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            int val = nums.get(i).get(0);
            maxVal = Math.max(maxVal, val);
            res[0] = Math.min(res[0], val);
            res[1] = maxVal;
            minHeap.offer(new int[]{val, i, 0});
        }

        while (true) {
            int[] curr = minHeap.poll();
            int listIndex = curr[1];
            int elementIndex = curr[2];
            int nextElementIndex = elementIndex + 1;
            if (nextElementIndex >= nums.get(listIndex).size()) {
                break;
            }

            int nextVal = nums.get(listIndex).get(nextElementIndex);
            maxVal = Math.max(maxVal, nextVal);

            /*
                should be before peek,
                [4] 5
                [9] 10
                2   [3]
                     ^ smallest is in the removing list.
            */
            minHeap.offer(new int[]{nextVal, listIndex, nextElementIndex});

            int nextMin = minHeap.peek()[0];
            if (maxVal - nextMin < res[1] - res[0]) {
                res[0] = nextMin;
                res[1] = maxVal;
            }
        }

        return res;
    }
}
