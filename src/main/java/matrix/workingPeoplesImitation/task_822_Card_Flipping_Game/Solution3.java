package matrix.workingPeoplesImitation.task_822_Card_Flipping_Game;

// from leetcode code sample (1)
public class Solution3 {
    public int flipgame(int[] fronts, int[] backs) {
        boolean[] appearBothSides = new boolean[2001];
        int n = fronts.length;
        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) {
                appearBothSides[fronts[i]] = true;
            }
        }

        int min = 2001;
        for (int i = 0; i < n; i++) {
            if (fronts[i] < min && !appearBothSides[fronts[i]]) {
                min = fronts[i];
            }
            if (backs[i] < min && !appearBothSides[backs[i]]) {
                min = backs[i];
            }
        }

        return min == 2001 ? 0 : min;
    }
}
