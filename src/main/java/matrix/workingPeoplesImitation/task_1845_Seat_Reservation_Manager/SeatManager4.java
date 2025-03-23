package matrix.workingPeoplesImitation.task_1845_Seat_Reservation_Manager;

import java.util.PriorityQueue;
import java.util.Queue;

// from walkccc.me
public class SeatManager4 {
    private int num = 0;
    private Queue<Integer> minHeap = new PriorityQueue<>();

    public SeatManager4(int n) {
    }

    public int reserve() {
        if (minHeap.isEmpty())
            return ++num;
        return minHeap.poll();
    }

    public void unreserve(int seatNumber) {
        minHeap.offer(seatNumber);
    }
}
