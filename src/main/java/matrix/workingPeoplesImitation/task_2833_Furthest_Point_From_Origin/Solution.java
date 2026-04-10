package matrix.workingPeoplesImitation.task_2833_Furthest_Point_From_Origin;

// my solution
public class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int countR = 0;
        int countL = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'R') {
                countR++;
            }
            if (move == 'L') {
                countL++;
            }
        }
        return moves.length() - Math.min(countR, countL) * 2;
    }
}
