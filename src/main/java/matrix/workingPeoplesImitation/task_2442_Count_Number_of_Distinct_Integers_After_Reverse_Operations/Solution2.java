package matrix.workingPeoplesImitation.task_2442_Count_Number_of_Distinct_Integers_After_Reverse_Operations;

// from leetcode code sample (1)
public class Solution2 {
    public int countDistinctIntegers(int[] nums) {
        boolean[] seen = new boolean[1000_001];
        int ans = 0;
        for (int x : nums) {
            if (!seen[x]) {
                seen[x] = true;
                ans++;
            }
            int reversed = 0;
            while (x > 0) {
                reversed = reversed * 10 + x % 10;
                x /= 10;
            }
            if (!seen[reversed]) {
                seen[reversed] = true;
                ans++;
            }
        }
        return ans;
    }

    int reverse(int n) {
        int val = 0;
        while (n > 0) {
            val = val * 10 + (n % 10);
            n /= 10;
        }
        return val;
    }
}
