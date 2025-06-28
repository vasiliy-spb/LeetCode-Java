package matrix.workingPeoplesImitation.task_3227_Vowels_Game_in_a_String;

// my solution
public class Solution {
    public boolean doesAliceWin(String s) {
        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return true;
            }
        }
        return false;
    }
}
