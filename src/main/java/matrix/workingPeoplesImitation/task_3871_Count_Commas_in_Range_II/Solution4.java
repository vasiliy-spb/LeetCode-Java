package matrix.workingPeoplesImitation.task_3871_Count_Commas_in_Range_II;

// from leetcode code sample (2)
public class Solution4 {
    public long countCommas(long n) {
        long count = 0;
        for (long p = 1000; p <= n; p *= 1000) {
            count += n - p + 1;
        }
        return count;
    }
}
