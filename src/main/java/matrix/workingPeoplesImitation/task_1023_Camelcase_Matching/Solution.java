package matrix.workingPeoplesImitation.task_1023_Camelcase_Matching;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            ans.add(isMatchWithPattern(queries[i], pattern));
        }
        return ans;
    }
    private boolean isMatchWithPattern(String s, String pattern) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (p < pattern.length() && ch == pattern.charAt(p)) {
                p++;
                continue;
            }
            if (Character.isUpperCase(ch)) {
                return false;
            }
        }
        return p == pattern.length();
    }
}
