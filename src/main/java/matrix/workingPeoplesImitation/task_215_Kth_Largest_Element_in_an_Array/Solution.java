package matrix.workingPeoplesImitation.task_215_Kth_Largest_Element_in_an_Array;

import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums)
            queue.offer(num);
        int n = nums.length - k;
        while (n-- > 0)
            queue.poll();
        return queue.poll();
    }
}
