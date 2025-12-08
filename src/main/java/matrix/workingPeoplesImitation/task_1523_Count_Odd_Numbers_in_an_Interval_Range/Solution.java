package matrix.workingPeoplesImitation.task_1523_Count_Odd_Numbers_in_an_Interval_Range;

// my solution
public class Solution {
    public int countOdds(int low, int high) {
        int ans = (high - low) / 2;
        if (low % 2 == 1 || high % 2 == 1) {
            ans++;
        }
        return ans;
    }
}
