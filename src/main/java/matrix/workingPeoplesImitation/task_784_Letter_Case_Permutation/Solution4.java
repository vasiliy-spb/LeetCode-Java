package matrix.workingPeoplesImitation.task_784_Letter_Case_Permutation;

import java.util.ArrayList;
import java.util.List;

// from leetcode code sample (2)
public class Solution4 {
    private List<String> result = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        helper(s, 0, new StringBuilder());
        return result;
    }
    public void helper(String s, int ind, StringBuilder sub) {
        if (ind == s.length()) {
            String sub1 = sub.toString();
            result.add(sub1);
            return;
        }
        char c = s.charAt(ind);
        if (!Character.isDigit(c)) {
            sub.append(Character.toLowerCase(c));
            helper(s, ind + 1, sub);
            sub.deleteCharAt(sub.length() - 1);
            sub.append(Character.toUpperCase(c));
        } else {
            sub.append(c);
        }
        helper(s, ind + 1, sub);
        sub.deleteCharAt(sub.length() - 1);
    }
}
