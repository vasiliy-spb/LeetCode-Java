package matrix.workingPeoplesImitation.task_3304_Find_the_K_th_Character_in_String_Game_I;

// my solution
public class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        while (sb.length() < k) {
            int length = sb.length();
            for (int i = 0; i < length; i++) {
                char ch = (char) (((sb.charAt(i) + 1 - 'a') % 26) + 'a');
                sb.append(ch);
            }
        }
        return sb.charAt(k - 1);
    }
}
