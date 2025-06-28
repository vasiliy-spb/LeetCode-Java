package matrix.workingPeoplesImitation.task_1642_Furthest_Building_You_Can_Reach;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    // my solution
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i + 1] > heights[i]) {
                if (bricks <= 0 && ladders == 0) return i;
                int diff = heights[i + 1] - heights[i];
                if (ladders == 0) {
                    bricks -= diff;
                } else if (!heap.isEmpty() && heap.size() >= ladders) {
                    if (diff <= heap.peek()) {
                        bricks -= diff;
                    } else {
                        bricks -= heap.poll();
                        heap.offer(diff);
                    }
                } else {
                    if (heap.size() <= ladders) heap.offer(diff);
                    else return i;
                }
                if (bricks < 0) return i;
            }
        }
        return heights.length - 1;
    }

    // from walkccc.me
    public int furthestBuilding1(int[] heights, int bricks, int ladders) {
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 1; i < heights.length; ++i) {
            final int diff = heights[i] - heights[i - 1];
            if (diff <= 0)
                continue;
            minHeap.offer(diff);
            // If we run out of ladders, greedily use as less bricks as possible.
            if (minHeap.size() > ladders)
                bricks -= minHeap.poll();
            if (bricks < 0)
                return i - 1;
        }

        return heights.length - 1;
    }

    // from velog.io
    public int furthestBuilding2(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < heights.length; i++) {
            int height = heights[i] - heights[i - 1];

            // skip condition
            if (height <= 0) continue;

            queue.offer(height);
            // able to use ladder
            if (queue.size() <= ladders) continue;

            // use bricks
            bricks -= queue.poll();
            // return previous building
            if (bricks < 0) return i - 1;
        }
        // all buildings are reached
        return heights.length - 1;
    }

    // from leetcode solutions
    //
    // Explanation
    // Heap heap store k height difference that we need to use ladders.
    // Each move, if the height difference d > 0,
    // we push d into the priority queue pq.
    // If the size of queue exceed ladders,
    // it means we have to use bricks for one move.
    // Then we pop out the smallest difference, and reduce bricks.
    // If bricks < 0, we can't make this move, then we return current index i.
    // If we can reach the last building, we return A.length - 1.
    public int furthestBuilding3(int[] A, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < A.length - 1; i++) {
            int d = A[i + 1] - A[i];
            if (d > 0)
                pq.add(d);
            if (pq.size() > ladders)
                bricks -= pq.poll();
            if (bricks < 0)
                return i;
        }
        return A.length - 1;
    }

}
