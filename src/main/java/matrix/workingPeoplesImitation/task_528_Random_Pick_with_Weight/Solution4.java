package matrix.workingPeoplesImitation.task_528_Random_Pick_with_Weight;

import java.util.LinkedList;
import java.util.Queue;

// from leetcode code sample (2)
public class Solution4 {
    Queue<Integer> queue = new LinkedList<>();

    public Solution4(int[] w) {
        int sum = 0;

        for (int num : w) sum += num;

        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < ((w[i] * 100) / sum); j++) queue.add(i);
        }
    }

    public int pickIndex() {
        if (queue.isEmpty()) return 0;
        int num = queue.poll();
        queue.add(num);
        return num;
    }
}
