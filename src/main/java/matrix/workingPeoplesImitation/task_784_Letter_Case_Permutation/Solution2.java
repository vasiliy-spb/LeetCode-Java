package matrix.workingPeoplesImitation.task_784_Letter_Case_Permutation;

import java.util.ArrayList;
import java.util.List;

// from walkccc.me
public class Solution2 {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        dfs(new StringBuilder(s), 0, ans);
        return ans;
    }

    private void dfs(StringBuilder sb, int i, List<String> ans) {
        if (i == sb.length()) {
            ans.add(sb.toString());
            return;
        }
        if (Character.isDigit(sb.charAt(i))) {
            dfs(sb, i + 1, ans);
            return;
        }

        sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
        dfs(sb, i + 1, ans);
        sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
        dfs(sb, i + 1, ans);
    }
}
