package matrix.workingPeoplesImitation.task_205_Isomorphic_Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int ch1 = s.charAt(i);
            int ch2 = t.charAt(i);
            if (map.containsKey(ch1)) {
                if (map.get(ch1) != ch2) return false;
            } else if (map.containsValue(ch2)) return false;
            else map.put(ch1, ch2);
        }
        return true;
    }
}
