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

    // from leetcode (https://leetcode.com/submissions/detail/1239059506/) решение https://leetcode.com/Iregor/
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int i = 0;
        for (; i < k && i < nums.length; i++) {
            heap.add(nums[i]);
        }
        for (; i < nums.length; i++) {
            heap.add(nums[i]);
            heap.poll();
        }
        return heap.peek();
    }

}
