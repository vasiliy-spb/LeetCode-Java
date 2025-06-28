package matrix.workingPeoplesImitation.task_2938_Separate_Black_and_White_Balls;

// from walkccc.me
public class Solution2 {
    public long minimumSteps(String s) {
        long ans = 0;
        int ones = 0;

        for (final char c : s.toCharArray())
            if (c == '1')
                ++ones;
            else // Move 1s to the front of the current '0'.
                ans += ones;

        return ans;
    }
}
