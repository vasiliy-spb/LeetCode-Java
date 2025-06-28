package matrix.workingPeoplesImitation.task_2028_Find_Missing_Observations;

import java.util.Arrays;

// from walkccc.me
public class Solution3 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        final int targetSum = (rolls.length + n) * mean;
        int missingSum = targetSum - Arrays.stream(rolls).sum();
        if (missingSum > n * 6 || missingSum < n)
            return new int[] {};

        int[] ans = new int[n];
        Arrays.fill(ans, missingSum / n);
        missingSum %= n;
        for (int i = 0; i < missingSum; ++i)
            ++ans[i];

        return ans;
    }
}
