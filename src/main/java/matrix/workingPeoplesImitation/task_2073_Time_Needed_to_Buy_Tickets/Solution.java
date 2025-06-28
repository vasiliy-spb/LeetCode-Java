package matrix.workingPeoplesImitation.task_2073_Time_Needed_to_Buy_Tickets;

public class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        while (tickets[k] > 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    tickets[i]--;
                    time += 1;
                }
                if (i == k && tickets[i] == 0) break;
            }
        }
        return time;
    }
}
