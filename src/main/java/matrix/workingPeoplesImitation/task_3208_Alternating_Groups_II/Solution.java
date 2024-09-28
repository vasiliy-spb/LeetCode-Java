package matrix.workingPeoplesImitation.task_3208_Alternating_Groups_II;

// my solution
public class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k)  {
        int n = colors.length;
        int count = 0;
        int prev = colors[0];
        int length = 1;
        boolean allValid = true;
        for (int i = 1; i < n + k; i++) {
            int index = i % n;
            if (i == n + k - 1) {
                count += allValid ? n : Math.max(length - k + 1, 0);
                length = 1;
            }
            if (colors[index] != prev) {
                length++;
            } else {
                allValid = false;
                count += Math.max(length - k + 1, 0);
                length = 1;
            }
            prev = colors[index];
        }
        return count;
    }
}
