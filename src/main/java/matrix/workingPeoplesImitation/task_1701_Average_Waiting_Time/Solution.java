package matrix.workingPeoplesImitation.task_1701_Average_Waiting_Time;

public class Solution {

    // my solution
    public double averageWaitingTime(int[][] customers) {
        long finish = customers[0][0];
        long totalWaitingTime = 0;
        for (int[] customer : customers) {
            if (finish > customer[0]) totalWaitingTime += finish - customer[0];
            else if (finish < customer[0]) finish = customer[0];
            totalWaitingTime += customer[1];
            finish += customer[1];
        }
        return (double) totalWaitingTime / customers.length;
    }

    // from leetcode editorial
    public double averageWaitingTime2(int[][] customers) {
        int nextIdleTime = 0;
        long netWaitTime = 0;

        for (int i = 0; i < customers.length; i++) {
            // The next idle time for the chef is given by the time of delivery
            // of current customer's order.
            nextIdleTime = Math.max(customers[i][0], nextIdleTime) +
                    customers[i][1];

            // The wait time for the current customer is the difference between
            // his delivery time and arrival time.
            netWaitTime += nextIdleTime - customers[i][0];
        }

        // Divide by total customers to get average.
        double averageWaitTime = (double) netWaitTime / customers.length;
        return averageWaitTime;
    }

    // from walkccc.me
    public double averageWaitingTime3(int[][] customers) {
        double wait = 0;
        double curr = 0;

        for (int[] c : customers) {
            curr = Math.max(curr, 1.0 * c[0]) + c[1];
            wait += curr - c[0];
        }

        return 1.0 * wait / customers.length;
    }

}
