package matrix.workingPeoplesImitation.task_292_Nim_Game;

public class Solution {
    // my solution
    public boolean canWinNim(int n) {
        return !(n % 4 == 0);
    }

    // from walkccc.me
    public boolean canWinNim2(int n) {
        return n % 4 != 0;
    }

}
