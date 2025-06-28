package matrix.workingPeoplesImitation.task_3227_Vowels_Game_in_a_String;

// from leetcode code sample
public class Solution3 {
    public boolean doesAliceWin(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    return true;
            }
        }
        return false;
    }
}
