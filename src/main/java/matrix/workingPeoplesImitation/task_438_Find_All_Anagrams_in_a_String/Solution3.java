package matrix.workingPeoplesImitation.task_438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.List;

// from leetcode code sample (1)
public class Solution3 {
    public List<Integer> findAnagrams(String s, String p) {
        var ans = new ArrayList<Integer>();
        int np = p.length(), ns = s.length();
        if (np > ns) {
            return ans;
        }
        int[] map = new int[26];
        for (int i = 0; i < np; i++) {
            map[p.charAt(i) - 'a']++;
            map[s.charAt(i) - 'a']--;
        }
        int diffCount = 0;
        for (int diff : map) {
            if (diff > 0) {
                diffCount++;
            }
        }
        if (diffCount == 0) {
            ans.add(0);
        }
        for (int i = 0, n = ns - np; i < n; i++) {
            if (++map[s.charAt(i) - 'a'] == 1) {
                diffCount++;
            }
            if (--map[s.charAt(i + np) - 'a'] == 0) {
                diffCount--;
            }
            if (diffCount == 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
