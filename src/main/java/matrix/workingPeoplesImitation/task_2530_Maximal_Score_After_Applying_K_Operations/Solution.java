package matrix.workingPeoplesImitation.task_2530_Maximal_Score_After_Applying_K_Operations;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// my solution
public class Solution {
    public long maxKelements(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            queue.offer(num);
        }
        long score = 0;
        while (k-- > 0) {
            int num = queue.poll();
            score += num;
            num = ceil(num);
            queue.offer(num);
        }
        return score;
    }

    private int ceil(int num) {
        int add = num % 3 == 0 ? 0 : 1;
        return num / 3 + add;
    }
}
