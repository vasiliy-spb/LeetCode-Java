package matrix.workingPeoplesImitation.task_2078_Two_Furthest_Houses_With_Different_Colors;

// my solution
class Solution {
    public int maxDistance(int[] colors) {
        int max = 0;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != colors[colors.length - 1]) {
                max = Math.max(max, colors.length - 1 - i);
            }
        }
        for (int i = colors.length - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                max = Math.max(max, i);
            }
        }
        return max;
    }
}
