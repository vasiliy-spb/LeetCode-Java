package matrix.workingPeoplesImitation.task_2078_Two_Furthest_Houses_With_Different_Colors;

// from walkccc.me
public class Solution3 {
    public int maxDistance(int[] colors) {
        final int n = colors.length;
        int i = 0;     // the leftmost index, where colors[i] != colors[n - 1]
        int j = n - 1; // the rightmost index, where colors[j] != colors[0]
        while (colors[i] == colors[n - 1]) {
            ++i;
        }
        while (colors[j] == colors[0]) {
            --j;
        }
        return Math.max(n - 1 - i, j);
    }
}
