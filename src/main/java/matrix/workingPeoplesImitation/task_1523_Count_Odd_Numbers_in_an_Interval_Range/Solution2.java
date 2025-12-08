package matrix.workingPeoplesImitation.task_1523_Count_Odd_Numbers_in_an_Interval_Range;

// from walkccc.me (rewrite from C++)
public class Solution2 {
    public int countOdds(int low, int high) {
        return (high + 1) / 2 - low / 2;
    }
}
