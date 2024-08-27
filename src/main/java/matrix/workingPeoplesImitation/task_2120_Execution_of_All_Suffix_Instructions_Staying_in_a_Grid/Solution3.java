package matrix.workingPeoplesImitation.task_2120_Execution_of_All_Suffix_Instructions_Staying_in_a_Grid;

// from leetcode code sample (1)
public class Solution3 {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        final int m = s.length();
        int[][] dirs = new int[m][];
        for (int i = 0; i < m; i++) {
            switch (s.charAt(i)) {
                case 'L':
                    dirs[i] = DIRS[0];
                    break;
                case 'R':
                    dirs[i] = DIRS[1];
                    break;
                case 'U':
                    dirs[i] = DIRS[2];
                    break;
                case 'D':
                    dirs[i] = DIRS[3];
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int y = startPos[0], x = startPos[1];
            int step = i;
            while (step < m) {
                y += dirs[step][0];
                x += dirs[step][1];
                if (y < 0 || y >= n || x < 0 || x >= n) {
                    break;
                }
                step++;
            }
            res[i] = step - i;
        }
        return res;
    }

    private static final int[][] DIRS = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

}
