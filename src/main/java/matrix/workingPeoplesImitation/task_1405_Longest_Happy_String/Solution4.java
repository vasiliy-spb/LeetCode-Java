package matrix.workingPeoplesImitation.task_1405_Longest_Happy_String;

// rewrite into java solution from walkccc.me
public class Solution4 {
    public String longestDiverseString(int a, int b, int c) {
        return longestDiverseString(a, b, c, 'a', 'b', 'c');
    }

    private String longestDiverseString(int a, int b, int c, char A, char B, char C) {
        if (a < b) {
            return longestDiverseString(b, a, c, B, A, C);
        }
        if (b < c) {
            return longestDiverseString(a, c, b, A, C, B);
        }
        if (b == 0) {
            return String.valueOf(A).repeat(Math.min(a, 2));
        }
        int useA = Math.min(a, 2);
        int useB = (a - useA >= b) ? 1 : 0;
        return String.valueOf(A).repeat(useA) +
                String.valueOf(B).repeat(useB) +
                longestDiverseString(a - useA, b - useB, c, A, B, C);
    }
}
