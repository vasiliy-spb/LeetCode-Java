package matrix.workingPeoplesImitation.task_1807_Evaluate_the_Bracket_Pairs_of_a_String;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// my solution
public class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> keys = new HashMap<>();
        for (List<String> l : knowledge) {
            keys.put(l.get(0), l.get(1));
        }

        StringBuilder ans = new StringBuilder();
        boolean inBrackets = false;
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                inBrackets = true;
            } else if (ch == ')') {
                if (!key.isEmpty()) {
                    ans.append(keys.getOrDefault(key.toString(), "?"));
                    key = new StringBuilder();
                }
                inBrackets = false;
            } else {
                if (inBrackets) {
                    key.append(ch);
                } else {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}
