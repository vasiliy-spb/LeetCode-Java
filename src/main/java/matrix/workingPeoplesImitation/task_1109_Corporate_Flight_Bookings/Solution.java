package matrix.workingPeoplesImitation.task_1109_Corporate_Flight_Bookings;

// my solution
public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] flights = new int[n];
        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            flights[first - 1] += seats;
            if (last < n) {
                flights[last] -= seats;
            }
        }
        for (int i = 1; i < n; i++) {
            flights[i] += flights[i - 1];
        }
        return flights;
    }
}