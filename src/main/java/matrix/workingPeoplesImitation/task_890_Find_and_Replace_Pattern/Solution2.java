package matrix.workingPeoplesImitation.task_890_Find_and_Replace_Pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// from walkccc.me
public class Solution2 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();

        for (final String word : words)
            if (isIsomorphic(word, pattern))
                ans.add(word);

        return ans;
    }

    private boolean isIsomorphic(final String w, final String p) {
        Map<Character, Integer> map_w = new HashMap<>();
        Map<Character, Integer> map_p = new HashMap<>();

        for (Integer i = 0; i < w.length(); ++i)
            if (map_w.put(w.charAt(i), i) != map_p.put(p.charAt(i), i))
                return false;

        return true;
    }
}
