package matrix.workingPeoplesImitation.task_3871_Count_Commas_in_Range_II;

// from leetcode code sample (1)
public class Solution3 {
    public long countCommas(long n) {
        long ans = 0;
        if (n < 1000) return 0;
        if (n < 1e6) return n - 999;
        ans += 1e6 - 1e3;
        if (n < 1e9) return ans + 2 * (n - 999999);
        ans += 2 * (1e9 - 1e6);
        if (n < 1e12) return ans + 3 * (n - 999999999);
        ans += 3 * (1e12 - 1e9);
        if (n < 1e15) return ans + 4 * (n - 999999999999L);
        ans += 4 * (1e15 - 1e12);
        if (n == 1e15) ans += 5;
        return ans;
    }
}
