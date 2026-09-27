package matrix.workingPeoplesImitation.task_3871_Count_Commas_in_Range_II;

// my solution
public class Solution {
    public long countCommas(long n) {
        long div = 999;
        long ans = 0;
        while (div < 10e15) {
            ans += Math.max(n - div, 0);
            div *= 1000;
            div += 999;
        }
        return ans;
    }
}
