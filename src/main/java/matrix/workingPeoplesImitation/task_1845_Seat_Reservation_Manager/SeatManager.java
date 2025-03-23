package matrix.workingPeoplesImitation.task_1845_Seat_Reservation_Manager;

import java.util.PriorityQueue;
import java.util.Queue;

// my solution
public class SeatManager {
    Queue<Integer> placeHolder;
    public SeatManager(int n) {
        this.placeHolder = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            this.placeHolder.offer(i);
        }
    }

    public int reserve() {
        return this.placeHolder.poll();
    }

    public void unreserve(int seatNumber) {
        this.placeHolder.offer(seatNumber);
    }
}
