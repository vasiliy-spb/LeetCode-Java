package matrix.workingPeoplesImitation.task_338_Counting_Bits;

public class Solution {

    // my solution
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int num = i;
            while (num > 0) {
                result[i] += num & 1;
                num = num >>> 1;
            }
        }
        return result;
    }

    // from walkccc.me
    public int[] countBits2(int n) {
        // f(i) := i's number of 1s in bitmask
        // f(i) = f(i / 2) + i % 2
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; ++i)
            ans[i] = ans[i / 2] + (i % 2);

        return ans;
    }
}
