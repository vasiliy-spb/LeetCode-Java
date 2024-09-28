package matrix.workingPeoplesImitation.task_2981_Find_Longest_Special_Substring_That_Occurs_Thrice_I;

import java.util.HashMap;
import java.util.Map;

// my solution
public class Solution {
    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder specialSubstring = new StringBuilder();
        char prev = s.charAt(0);
        for (char ch : s.toCharArray()) {
            if (ch != prev) {
                specialSubstring = new StringBuilder();
            }
            specialSubstring.append(ch);
            map.merge(specialSubstring.toString(), 1, Integer::sum);
            int count = specialSubstring.length();
            while (count > 1) {
                map.merge(String.valueOf(ch).repeat(count - 1), specialSubstring.length() - count + 1, Integer::sum);
                count--;
            }
            prev = ch;
        }
        int maxLength = -1;
        for (String key : map.keySet()) {
            if (map.get(key) > 2) {
                maxLength = Math.max(maxLength, key.length());
            }
            if (key.length() > 2) {
                maxLength = Math.max(maxLength, key.length() - 2);
            }
        }
        return maxLength;
    }
}
