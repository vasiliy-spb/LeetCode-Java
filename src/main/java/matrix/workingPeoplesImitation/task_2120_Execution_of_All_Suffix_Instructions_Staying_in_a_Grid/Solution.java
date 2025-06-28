package matrix.workingPeoplesImitation.task_2120_Execution_of_All_Suffix_Instructions_Staying_in_a_Grid;

// my solution
public class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int y = startPos[0];
            int x = startPos[1];
            for (int j = i; j < m; j++) {
                char instr = s.charAt(j);
                switch (instr) {
                    case 'U' -> y--;
                    case 'R' -> x++;
                    case 'D' -> y++;
                    case 'L' -> x--;
                }
                if (x < 0 || y < 0 || x >= n || y >= n) {
                    break;
                }
                ans[i]++;
            }
        }
        return ans;
    }
}
