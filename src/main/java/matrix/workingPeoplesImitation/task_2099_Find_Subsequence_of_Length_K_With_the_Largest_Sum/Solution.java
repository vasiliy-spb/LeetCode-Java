package matrix.workingPeoplesImitation.task_2099_Find_Subsequence_of_Length_K_With_the_Largest_Sum;

import java.util.PriorityQueue;
import java.util.Queue;

// my solution
public class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        Queue<int[]> heap = new PriorityQueue<>((a1, a2) -> Integer.compare(a2[0], a1[0]));
        for (int i = 0; i < nums.length; i++) {
            heap.offer(new int[]{nums[i], i});
        }
        Queue<int[]> indexHeap = new PriorityQueue<>((a1, a2) -> Integer.compare(a1[1], a2[1]));
        for (int i = 0; i < k; i++) {
            indexHeap.offer(heap.poll());
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = indexHeap.poll()[0];
        }
        return ans;
    }
}
