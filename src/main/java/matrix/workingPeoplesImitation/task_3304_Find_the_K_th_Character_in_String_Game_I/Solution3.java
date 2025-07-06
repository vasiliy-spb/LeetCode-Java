package matrix.workingPeoplesImitation.task_3304_Find_the_K_th_Character_in_String_Game_I;

// from walkccc.me
public class Solution3 {
    public char kthCharacter(int k) {
        return (char) ('a' + Integer.bitCount(k - 1));
    }
}
