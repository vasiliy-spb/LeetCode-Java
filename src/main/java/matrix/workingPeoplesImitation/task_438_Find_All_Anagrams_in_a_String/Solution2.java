package matrix.workingPeoplesImitation.task_438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.List;

// from walkccc.me
public class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[128];
        int required = p.length();

        for (final char c : p.toCharArray())
            ++count[c];

        for (int l = 0, r = 0; r < s.length(); ++r) {
            if (--count[s.charAt(r)] >= 0)
                --required;
            while (required == 0) {
                if (r - l + 1 == p.length())
                    ans.add(l);
                if (++count[s.charAt(l++)] > 0)
                    ++required;
            }
        }

        return ans;
    }
}
