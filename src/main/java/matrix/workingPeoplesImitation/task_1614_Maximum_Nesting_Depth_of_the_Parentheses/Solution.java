package matrix.workingPeoplesImitation.task_1614_Maximum_Nesting_Depth_of_the_Parentheses;

public class Solution {

    // my solution
    public int maxDepth(String s) {
        int result = 0;
        int currentDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                currentDepth++;
                result = Math.max(result, currentDepth);
            }
            if (s.charAt(i) == ')') {
                currentDepth--;
            }
        }
        return result;
    }

    // from walkccc.me
    public int maxDepth2(String s) {
        int ans = 0;
        int opened = 0;

        for (final char c : s.toCharArray())
            if (c == '(')
                ans = Math.max(ans, ++opened);
            else if (c == ')')
                --opened;

        return ans;
    }
}
