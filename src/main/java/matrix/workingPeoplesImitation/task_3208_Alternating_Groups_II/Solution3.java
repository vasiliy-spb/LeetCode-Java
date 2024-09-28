package matrix.workingPeoplesImitation.task_3208_Alternating_Groups_II;

// from leetcode solutions (1)
public class Solution3 {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int left = 0;
        int count = 0;
        int len = colors.length;

        for (int right = 1; right < 2 * len; right ++) {
            int curr = right % len;
            int prev = (right - 1) % len;

            if (colors[curr] == colors[prev]) {
                left = right % len;
            }
            if (right - left + 1 == k) {
                count++;
                left = (left + 1) % len;
            }
        }
        return count;
    }
}
