package matrix.workingPeoplesImitation.task_1962_Remove_Stones_to_Minimize_the_Total;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// my solution
public class Solution {
    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int pile : piles) {
            queue.offer(pile);
        }
        while (k-- > 0) {
            int num = queue.poll();
            queue.offer(num - num / 2);
        }
        return queue.stream().mapToInt(Integer::intValue).sum();
    }
}
