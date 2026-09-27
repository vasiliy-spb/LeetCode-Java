package matrix.workingPeoplesImitation.task_3871_Count_Commas_in_Range_II;

// from leetcode editorial (Approach: Place Value Contribution)
public class Solution2 {
    public long countCommas(long n) {
        long p = 1000, res = 0;
        while (p <= n) {
            res += n - p + 1;
            p *= 1000;
        }
        return res;
    }
}
