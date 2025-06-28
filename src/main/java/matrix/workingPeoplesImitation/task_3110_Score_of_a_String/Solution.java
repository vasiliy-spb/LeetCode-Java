package matrix.workingPeoplesImitation.task_3110_Score_of_a_String;

public class Solution {

    // my solution
    public int scoreOfString(String s) {
        int score = 0;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            score += Math.abs(prev - ch);
            prev = ch;
        }
        return score;
    }

    // from walkccc.me
    public int scoreOfString2(String s) {
        int ans = 0;

        for (int i = 1; i < s.length(); ++i)
            ans += Math.abs(s.charAt(i) - s.charAt(i - 1));

        return ans;
    }

}
