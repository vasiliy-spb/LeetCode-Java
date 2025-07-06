package matrix.workingPeoplesImitation.task_3361_Shift_Distance_Between_Two_Strings;

// my solution
public class Solution {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        long[] forwardSum = new long[26];
        for (int i = 0; i < 26; i++) {
            forwardSum[i] = nextCost[i];
            if (i > 0) {
                forwardSum[i] += forwardSum[i - 1];
            }
        }
        long[] backwardSum = new long[26];
        for (int i = 25; i >= 0; i--) {
            backwardSum[i] = previousCost[i];
            if (i < 25) {
                backwardSum[i] += backwardSum[i + 1];
            }
        }

        int n = s.length();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int target = t.charAt(i) - 'a';
            int current = s.charAt(i) - 'a';

            if (target == current) {
                continue;
            }

            long forwardCost;
            long backwardCost;
            if (target > current) {
                // 0-----c-----t-----n
                //      [c-----t)       -->>
                forwardCost = forwardSum[target] - nextCost[target] - forwardSum[current] + nextCost[current];

                // 0-----c-----t-----n
                //[0-----c]   (t-----n]  <<--
                backwardCost = backwardSum[0] - backwardSum[current] + previousCost[current];
                backwardCost += backwardSum[target] - previousCost[target];
            } else {
                // 0-----t-----c-----n
                //[0-----t)   [c-----n]  -->>
                forwardCost = forwardSum[25] - forwardSum[current] + nextCost[current];
                forwardCost += forwardSum[target] - nextCost[target];

                // 0-----t-----c-----n
                //      (t-----c]       <<--
                backwardCost = backwardSum[target] - backwardSum[current] + previousCost[current] - previousCost[target];
            }
            ans += Math.min(forwardCost, backwardCost);
        }
        return ans;
    }
}
