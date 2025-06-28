package matrix.workingPeoplesImitation.task_2982_Find_Longest_Special_Substring_That_Occurs_Thrice_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// from leetcode code sample (5)
public class Solution7 {
    public int maximumLength(String s) {
        List<Integer>[] map = new ArrayList[26];
        for (int x = 0; x < 26; x++) {
            map[x] = new ArrayList<>();
        }
        int i = 0;
        while (i < s.length()) {
            int count = 0;
            Character c = s.charAt(i);
            while (i < s.length() && s.charAt(i) == c) {
                i++;
                count++;
            }
            map[(int) c - (int) 'a'].add(count);
            //list.add(count);
        }
        Integer max = -1;
        for (i = 0; i < 26; i++) {
            List<Integer> list = map[i];
            if (list.size() == 0) continue;
            Collections.sort(list);
            int size = list.size();
            Integer val = list.get(size - 1) - 2;
            if (size >= 2) val = Math.max(val, Math.min(list.get(size - 1) - 1, list.get(size - 2)));
            if (size >= 3) val = Math.max(val, Math.min(list.get(size - 1) - 2, list.get(size - 3)));
            if (size >= 3) val = Math.max(val, list.get(size - 3));
            max = Math.max(max, val);
        }
        return max == 0 ? -1 : max;
    }
}
