package matrix.workingPeoplesImitation.task_1845_Seat_Reservation_Manager;

import java.util.PriorityQueue;

// from leetcode editorial (Approach 2: Min Heap (without pre-initialization))
public class SeatManager2 {
    // Marker to point to unreserved seats.
    int marker;

    // Min heap to store all unreserved seats.
    PriorityQueue<Integer> availableSeats;

    public SeatManager2(int n) {
        // Set marker to the first unreserved seat.
        marker = 1;
        // Initialize the min heap.
        availableSeats = new PriorityQueue<>();
    }

    public int reserve() {
        // If min-heap has any element in it, then,
        // get the smallest-numbered unreserved seat from the min heap.
        if (!availableSeats.isEmpty()) {
            int seatNumber = availableSeats.poll();
            return seatNumber;
        }

        // Otherwise, the marker points to the smallest-numbered seat.
        int seatNumber = marker;
        marker++;
        return seatNumber;
    }

    public void unreserve(int seatNumber) {
        // Push unreserved seat in the min heap.
        availableSeats.offer(seatNumber);
    }
}
