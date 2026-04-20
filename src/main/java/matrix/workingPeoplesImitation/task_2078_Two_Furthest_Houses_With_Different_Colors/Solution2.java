package matrix.workingPeoplesImitation.task_2078_Two_Furthest_Houses_With_Different_Colors;

// from leetcode editorial (Approach: Enumeration)
public class Solution2 {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int res = 0; // the maximum distance between two houses of different colors
        // traverse the indices of two houses and maintain the maximum distance
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (colors[i] != colors[j]) {
                    res = Math.max(res, j - i);
                }
            }
        }
        return res;
    }
}
