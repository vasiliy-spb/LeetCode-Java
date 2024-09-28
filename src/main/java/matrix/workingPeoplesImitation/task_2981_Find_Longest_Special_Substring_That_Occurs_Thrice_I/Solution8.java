package matrix.workingPeoplesImitation.task_2981_Find_Longest_Special_Substring_That_Occurs_Thrice_I;

import java.util.HashMap;
import java.util.Map;

// from leetcode code sample (6)
public class Solution8 {
    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();
        int max = -1;
        for (int i = 0; i < s.length(); i++){
            for (int j = i+1; j <= s.length(); j++){
                if(s.charAt(j-1) != s.charAt(i)) {
                    break;
                }
                final var substr = s.substring(i, j);
                final var count = map.merge(substr, 1, (o, n) -> o+1 );
                if (count == 3) {
                    max = Math.max(max, substr.length());
                }

            }
        }
        return max;
    }
}
