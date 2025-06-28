package matrix.workingPeoplesImitation.task_703_Kth_Largest_Element_in_a_Stream;

import java.util.PriorityQueue;
import java.util.Queue;

// from walkccc.me
public class KthLargest4 {
    public KthLargest4(int k, int[] nums) {
        this.k = k;
        for (final int num : nums)
            heapify(num);
    }

    public int add(int val) {
        heapify(val);
        return minHeap.peek();
    }

    private final int k;
    private Queue<Integer> minHeap = new PriorityQueue<>();

    private void heapify(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k)
            minHeap.poll();
    }
}
