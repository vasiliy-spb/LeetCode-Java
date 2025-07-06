package matrix.workingPeoplesImitation.task_3361_Shift_Distance_Between_Two_Strings;

// from walkccc.me
public class Solution2 {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        long ans = 0;
        // prev[i][j]: the prev cost to shift from ('a' + i) to ('a' + j)
        long[][] prev = new long[26][26];
        // next[i][j]: the next cost to shift from ('a' + i) to ('a' + j)
        long[][] next = new long[26][26];

        for (int i = 0; i < 26; ++i) {
            long cost = 0;
            for (int j = 0; j < 26; ++j) {
                next[i][(i + j) % 26] = cost;
                cost += nextCost[(i + j) % 26];
            }
        }

        for (int i = 0; i < 26; ++i) {
            long cost = 0;
            for (int j = 0; j < 26; ++j) {
                prev[i][(i - j + 26) % 26] = cost;
                cost += previousCost[(i - j + 26) % 26];
            }
        }

        for (int i = 0; i < s.length(); ++i) {
            final int from = s.charAt(i) - 'a';
            final int to = t.charAt(i) - 'a';
            ans += Math.min(next[from][to], prev[from][to]);
        }

        // add from me
//        System.out.println();
//        System.out.println("prev:");
//        print(prev);
//        System.out.println();
//        System.out.println("next:");
//        print(next);

        return ans;
    }

    // add from me
    private void print(long[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
