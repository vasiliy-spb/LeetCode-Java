package matrix.workingPeoplesImitation.task_3498_Reverse_Degree_of_a_String;

// my solution
public class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            ans += (26 - (ch - 'a')) * (i + 1);
        }
        return ans;
    }
}
