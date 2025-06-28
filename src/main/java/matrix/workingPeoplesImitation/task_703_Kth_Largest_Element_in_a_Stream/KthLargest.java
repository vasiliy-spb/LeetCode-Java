package matrix.workingPeoplesImitation.task_703_Kth_Largest_Element_in_a_Stream;

import java.util.*;

// my solution
public class KthLargest {
    Queue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
        } else if (val > queue.peek()) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}
