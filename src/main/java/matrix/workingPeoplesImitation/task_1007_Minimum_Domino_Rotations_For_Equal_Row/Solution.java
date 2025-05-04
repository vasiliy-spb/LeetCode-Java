package matrix.workingPeoplesImitation.task_1007_Minimum_Domino_Rotations_For_Equal_Row;

// my solution
public class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int number1 = tops[0];
        int number2 = bottoms[0];
        int[] top = new int[2];
        int[] bottom = new int[2];
        for (int i = 0; i < tops.length; i++) {
            int t = tops[i];
            int b = bottoms[i];
            if (t != number1 && t != number2 && b != number1 && b != number2) {
                return -1;
            }
            if (t != number1 && b != number1) {
                top[0] = -1;
                bottom[0] = -1;
            }
            if (t != number2 && b != number2) {
                top[1] = -1;
                bottom[1] = -1;
            }
            if (top[0] >= 0) {
                top[0] += t == number1 ? 0 : 1;
                bottom[0] += b == number1 ? 0 : 1;
            }
            if (top[1] >= 0) {
                top[1] += t == number2 ? 0 : 1;
                bottom[1] += b == number2 ? 0 : 1;
            }
        }
        int minRotations = tops.length;
        if (top[0] >= 0) {
            minRotations = Math.min(minRotations, top[0]);
        }
        if (top[1] >= 0) {
            minRotations = Math.min(minRotations, top[1]);
        }
        if (bottom[0] >= 0) {
            minRotations = Math.min(minRotations, bottom[0]);
        }
        if (bottom[1] >= 0) {
            minRotations = Math.min(minRotations, bottom[1]);
        }
        return minRotations == tops.length ? -1 : minRotations;
    }
}
