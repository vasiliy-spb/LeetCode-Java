package matrix.workingPeoplesImitation.task_190_Reverse_Bits;

// from leetcode code sample (1)
public class Solution3 {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = ans << 1;
            ans = ans | (n & 1);
            n = n >> 1;
        }
        return ans;
    }
}
