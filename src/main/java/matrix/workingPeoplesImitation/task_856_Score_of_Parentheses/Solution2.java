package matrix.workingPeoplesImitation.task_856_Score_of_Parentheses;

// from leetcode code sample (1)
public class Solution2 {
    public int scoreOfParentheses(String s) {
        int ans = 0;
        int depth = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                if (s.charAt(i - 1) == '(') {
                    ans += 1 << depth;
                }
            }
        }
        return ans;
    }
}
