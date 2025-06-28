package matrix.workingPeoplesImitation.task_703_Kth_Largest_Element_in_a_Stream;

import java.util.PriorityQueue;

// from leetcode editorial (Approach 2: Heap)
public class KthLargest3 {
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest3(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        // Add to our minHeap if we haven't processed k elements yet
        // or if val is greater than the top element (the k-th largest)
        if (minHeap.size() < k || minHeap.peek() < val) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
}
