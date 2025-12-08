package matrix.workingPeoplesImitation.task_1523_Count_Odd_Numbers_in_an_Interval_Range;

// from leetcode code sample (1)
public class Solution3 {
    public int countOdds(int low, int high) {
        int n = high - low + 1;
        if (low % 2 != 0 && high % 2 != 0) {
            return (n / 2) + 1;
        }
        return (n / 2);
    }
}
