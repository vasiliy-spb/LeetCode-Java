package matrix.workingPeoplesImitation.task_2233_Maximum_Product_After_K_Increments;

import java.util.PriorityQueue;
import java.util.Queue;

// my solution
public class Solution {
    public int maximumProduct(int[] nums, int k) {
        int modulo = 1_000_000_007;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
        }
        while (k-- > 0) {
            int current = queue.poll();
            queue.offer(current + 1);
        }
        long product = 1;
        while (!queue.isEmpty()) {
            product *= queue.poll();
            product %= modulo;
        }
        return (int) product;
    }
}
