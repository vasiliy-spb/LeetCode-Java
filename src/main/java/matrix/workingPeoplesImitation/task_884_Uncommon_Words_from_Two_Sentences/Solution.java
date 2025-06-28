package matrix.workingPeoplesImitation.task_884_Uncommon_Words_from_Two_Sentences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// my solution
public class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : s1.split(" ")) {
            map.merge(s, 1, Integer::sum);
        }
        for (String s : s2.split(" ")) {
            map.merge(s, 1, Integer::sum);
        }
        List<String> ans = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                ans.add(s);
            }
        }
        return ans.toArray(new String[0]);
    }
}
