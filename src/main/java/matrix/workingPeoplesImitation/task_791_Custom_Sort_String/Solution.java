package matrix.workingPeoplesImitation.task_791_Custom_Sort_String;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray())
            map.merge(ch, 1, Integer::sum);
        StringBuilder result = new StringBuilder();
        char prev = '\0';
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if (ch == prev) continue;
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                while (count > 0) {
                    result.append(ch);
                    count--;
                }
                map.remove(ch);
            }
            prev = ch;
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            while (count > 0) {
                result.append(entry.getKey());
                count--;
            }
        }
        return result.toString();
    }
}
