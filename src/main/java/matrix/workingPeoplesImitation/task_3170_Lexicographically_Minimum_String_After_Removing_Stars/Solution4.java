package matrix.workingPeoplesImitation.task_3170_Lexicographically_Minimum_String_After_Removing_Stars;

import java.util.ArrayList;
import java.util.List;

// from walkccc.me
public class Solution4 {
    public String clearStars(String s) {
        StringBuilder sb = new StringBuilder(s);
        List<Integer>[] buckets = new List[26];

        for (int i = 0; i < 26; ++i)
            buckets[i] = new ArrayList<>();

        for (int i = 0; i < s.length(); ++i)
            if (s.charAt(i) == '*') {
                sb.setCharAt(i, ' ');
                int j = 0;
                while (buckets[j].isEmpty())
                    ++j;
                sb.setCharAt(buckets[j].remove(buckets[j].size() - 1), ' ');
            } else {
                buckets[s.charAt(i) - 'a'].add(i);
            }

        return sb.toString().replaceAll(" ", "");
    }
}
