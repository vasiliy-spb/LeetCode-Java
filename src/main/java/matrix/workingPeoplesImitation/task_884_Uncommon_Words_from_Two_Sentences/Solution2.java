package matrix.workingPeoplesImitation.task_884_Uncommon_Words_from_Two_Sentences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// from walkccc.me
public class Solution2 {
    public String[] uncommonFromSentences(String A, String B) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();

        for (final String word : (A + ' ' + B).split(" "))
            count.merge(word, 1, Integer::sum);

        for (final String word : count.keySet())
            if (count.get(word) == 1)
                ans.add(word);

        return ans.toArray(new String[0]);
    }
}
