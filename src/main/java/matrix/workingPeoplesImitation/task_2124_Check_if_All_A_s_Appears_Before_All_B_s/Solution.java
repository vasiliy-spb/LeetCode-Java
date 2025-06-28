package matrix.workingPeoplesImitation.task_2124_Check_if_All_A_s_Appears_Before_All_B_s;

// my solution
public class Solution {
    public boolean checkString(String s) {
        if (s.indexOf('b') < 0) {
            return true;
        }
        return s.lastIndexOf('a') < s.indexOf('b');
    }
}
