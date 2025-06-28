package matrix.workingPeoplesImitation.task_890_Find_and_Replace_Pattern;

import java.util.ArrayList;
import java.util.List;

// from leetcode code sample (1)
public class Solution3 {
    char[] pat;
    int[] map;
    boolean[] vis;
    int n;
    public List<String> findAndReplacePattern(String[] arr, String pat) {
        this.pat = pat.toCharArray();
        this.n = pat.length();
        List<String> list = new ArrayList<>();
        for (String st : arr) {
            if (valid(st)) list.add(st);
        }
        return list;
    }
    private boolean valid(String st) {
        map = new int[26];
        vis = new boolean[26];
        char[] sarr = st.toCharArray();
        for (int i = 0; i < n; i++) {
            char s = sarr[i];
            char p = pat[i];
            if (map[p - 'a'] == 0 && !vis[s - 'a']) {
                map[p - 'a'] = s;
                vis[s - 'a'] = true;
            } else if (map[p - 'a'] != s) {
                return false;
            }
        }
        return true;
    }
}
