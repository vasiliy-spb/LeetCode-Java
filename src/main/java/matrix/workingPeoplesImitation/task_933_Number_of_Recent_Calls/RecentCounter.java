package matrix.workingPeoplesImitation.task_933_Number_of_Recent_Calls;

import java.util.PriorityQueue;
import java.util.Queue;

public class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new PriorityQueue<>();
    }

    public int ping(int t) {
        this.queue.offer(t);
        int count = 0;
        for (int time : this.queue) {
            if (time >= t - 3000) count++;
        }
        return count;
    }

    // from walkccc.me
    public int ping2(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000)
            queue.poll();
        return queue.size();
    }

}
