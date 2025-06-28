package matrix.workingPeoplesImitation.task_2028_Find_Missing_Observations;

import java.util.Arrays;

// my solution
public class Solution {
    public int[] missingRolls0(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int[] ans = new int[n];
        int totalSum = (n + m) * mean;
        int sumM = Arrays.stream(rolls).sum();
        if (totalSum - sumM < n) {
            return new int[]{};
        }
        if ((n * 6 + sumM) / (n + m) < mean) {
            return new int[]{};
        }
        totalSum -= sumM + n;
        for (int i = 0; i < n; i++) {
            if (totalSum > 0) {
                ans[i] += Math.min(5, totalSum);
                totalSum -= Math.min(5, totalSum);
            }
            ans[i]++;
        }
        return ans;
    }
}
