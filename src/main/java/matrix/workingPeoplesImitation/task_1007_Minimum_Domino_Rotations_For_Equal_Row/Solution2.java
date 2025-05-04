package matrix.workingPeoplesImitation.task_1007_Minimum_Domino_Rotations_For_Equal_Row;

// my solution
public class Solution2 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int count1 = check(tops[0], tops, bottoms);
        int count2 = check(bottoms[0], tops, bottoms);
        if (count1 < 0 && count2 < 0) {
            return -1;
        }
        count1 = (count1 < 0) ? tops.length : count1;
        count2 = (count2 < 0) ? tops.length : count2;
        return Math.min(count1, count2);
    }

    private int check(int value, int[] tops, int[] bottoms) {
        int topRotations = 0;
        int bottomRotations = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != value && bottoms[i] != value) {
                return -1;
            }
            topRotations += (tops[i] == value) ? 0 : 1;
            bottomRotations += (bottoms[i] == value) ? 0 : 1;
        }
        return Math.min(topRotations, bottomRotations);
    }
}
