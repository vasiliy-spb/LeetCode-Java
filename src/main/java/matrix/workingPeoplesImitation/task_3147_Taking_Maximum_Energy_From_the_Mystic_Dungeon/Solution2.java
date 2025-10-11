package matrix.workingPeoplesImitation.task_3147_Taking_Maximum_Energy_From_the_Mystic_Dungeon;

import java.util.Arrays;

// from walkccc.me
public class Solution2 {
    public int maximumEnergy(int[] energy, int k) {
        int[] dp = energy.clone();
        for (int i = energy.length - 1 - k; i >= 0; --i) {
            dp[i] += dp[i + k];
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
