package matrix.workingPeoplesImitation.task_22_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // my solution
    public List<String> generateParenthesis3(int n) {
        List<String> result = new ArrayList<>();
        generateStrings(n, result, new StringBuilder(), 0, 0, 0);
        return result;
    }
    private void generateStrings(int n, List<String> result, StringBuilder stringBuilder, int open, int close, int start) {
        if (open == close && open == n) {
            result.add(stringBuilder.toString());
            return;
        }
        for (int i = start; i < n * 2; i++) {
            if (open < n) {
                stringBuilder.append("(");
                generateStrings(n, result, stringBuilder, open + 1, close, i + 1);
                stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            }
            if (close < open) {
                stringBuilder.append(")");
                generateStrings(n, result, stringBuilder, open, close + 1, i + 1);
                stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            }
        }
    }

    // from walkccc.me
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        dfs(n, n, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(int l, int r, final StringBuilder sb, List<String> ans) {
        if (l == 0 && r == 0) {
            ans.add(sb.toString());
            return;
        }

        if (l > 0) {
            sb.append("(");
            dfs(l - 1, r, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (l < r) {
            sb.append(")");
            dfs(l, r - 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // from GPT (dp approach)
    public static List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        List<String> initial = new ArrayList<>();
        initial.add("");
        dp.add(initial);

        for (int i = 1; i <= n; i++) {
            List<String> currentList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> inside = dp.get(j);
                List<String> outside = dp.get(i - 1 - j);
                for (String insideStr : inside) {
                    for (String outsideStr : outside) {
                        currentList.add("(" + insideStr + ")" + outsideStr);
                    }
                }
            }
            dp.add(currentList);
        }

        return dp.get(n);
    }

    // from leetcode (https://leetcode.com/submissions/detail/1238882605/) решение https://leetcode.com/Iregor/
    public List<String> generateParenthesis4(int n) {
        List<String> res = new ArrayList<>();
        generateRec(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void generateRec(List<String> res, StringBuilder cur, int opened, int closed, int n) {
        if (opened == closed && n == opened) {
            res.add(cur.toString());
        }
        if (opened < n) {
            generateRec(res, cur.append('('), opened + 1, closed, n);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (closed < opened) {
            generateRec(res, cur.append(')'), opened, closed + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
