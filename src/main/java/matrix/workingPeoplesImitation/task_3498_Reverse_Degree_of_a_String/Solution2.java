package matrix.workingPeoplesImitation.task_3498_Reverse_Degree_of_a_String;

// from leetcode editorial (Approach: Simulation)
public class Solution2 {
    public int reverseDegree(String s) {
        int ans = 0;
        for (int i = 1; i <= s.length(); i++) {
            ans += (26 - (s.charAt(i - 1) - 'a')) * i;
        }
        return ans;
    }
}
