package matrix.workingPeoplesImitation.task_3318_Find_X_Sum_of_All_K_Long_Subarrays_I;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// my solution
public class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            ans[i] = calculateSum(nums, i, x, k);
        }
        return ans;
    }

    private int calculateSum(int[] nums, int start, int x, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = start; i < start + k; i++) {
            frequencies.merge(nums[i], 1, Integer::sum);
        }
        Queue<int[]> queue = new PriorityQueue<>((a1, a2) -> {
            if (a1[1] == a2[1]) {
                return Integer.compare(a2[0], a1[0]);
            }
            return Integer.compare(a2[1], a1[1]);
        });
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        int sum = 0;
        while (!queue.isEmpty() && x > 0) {
            sum += queue.peek()[0] * queue.poll()[1];
            x--;
        }
        return sum;
    }
}
