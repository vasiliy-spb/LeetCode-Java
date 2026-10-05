package matrix.workingPeoplesImitation.task_856_Score_of_Parentheses;

// from walkccc.me
public class Solution6 {
    public int scoreOfParentheses(String s) {
        int ans = 0;
        int layer = 0;

        for (int i = 0; i + 1 < s.length(); ++i) {
            final char a = s.charAt(i);
            final char b = s.charAt(i + 1);
            if (a == '(' && b == ')') {
                ans += 1 << layer;
            }
            layer += a == '(' ? 1 : -1;
        }

        return ans;
    }
}
