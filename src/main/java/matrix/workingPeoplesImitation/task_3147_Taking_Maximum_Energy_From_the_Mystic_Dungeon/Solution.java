package matrix.workingPeoplesImitation.task_3147_Taking_Maximum_Energy_From_the_Mystic_Dungeon;

// my solution
public class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] suffixSum = new int[n];
        int ans = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (i + k < n) {
                suffixSum[i] += suffixSum[i + k];
            }
            suffixSum[i] += energy[i];
            ans = Math.max(ans, suffixSum[i]);
        }
        return ans;
    }
}
