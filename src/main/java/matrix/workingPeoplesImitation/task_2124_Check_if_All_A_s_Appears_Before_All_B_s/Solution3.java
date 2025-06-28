package matrix.workingPeoplesImitation.task_2124_Check_if_All_A_s_Appears_Before_All_B_s;

// from leetcode code sample
public class Solution3 {
    public boolean checkString(String s) {
        int a = s.indexOf("ba");
        if (a == -1) {
            return true;
        }
        return false;
    }
}
