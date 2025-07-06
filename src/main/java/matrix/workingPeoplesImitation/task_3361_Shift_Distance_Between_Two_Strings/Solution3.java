package matrix.workingPeoplesImitation.task_3361_Shift_Distance_Between_Two_Strings;

// from leetcode code sample (1)
public class Solution3 {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        long ans = 0;
        int n = s.length();

        long[] forward = new long[27];
        long[] backward = new long[27];

        for (int i = 1; i < 27; i++) {
            forward[i] = forward[i - 1] + nextCost[i - 1];
        }

        for (int i = 25; i >= 0; i--) {
            backward[i] = backward[i + 1] + previousCost[i];
        }

        for (int i = 0; i < n; i++) {
            int cs = s.charAt(i) - 'a';
            int ct = t.charAt(i) - 'a';

            if (cs == ct) continue;

            // Calculate forward cost
            long forwardCost = cs <= ct ? forward[ct] - forward[cs]
                    : forward[26] - forward[cs] + forward[ct];

            long backwardCost = cs <= ct ? backward[0] - backward[cs + 1] + backward[ct + 1]
                    : backward[ct + 1] - backward[cs + 1];

            ans += Math.min(forwardCost, backwardCost);
        }

        return ans;
    }
}

