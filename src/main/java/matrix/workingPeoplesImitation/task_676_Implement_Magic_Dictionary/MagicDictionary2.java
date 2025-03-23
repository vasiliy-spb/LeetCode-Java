package matrix.workingPeoplesImitation.task_676_Implement_Magic_Dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// from leetcode editorial (Approach #1: Brute Force with Bucket-By-Length [Accepted])
public class MagicDictionary2 {
    Map<Integer, ArrayList<String>> buckets;

    public MagicDictionary2() {
        buckets = new HashMap();
    }

    public void buildDict(String[] words) {
        for (String word : words) {
            buckets.computeIfAbsent(word.length(), x -> new ArrayList()).add(word);
        }
    }

    public boolean search(String word) {
        if (!buckets.containsKey(word.length())) return false;
        for (String candidate : buckets.get(word.length())) {
            int mismatch = 0;
            for (int i = 0; i < word.length(); ++i) {
                if (word.charAt(i) != candidate.charAt(i)) {
                    if (++mismatch > 1) {
                        break;
                    }
                }
            }
            if (mismatch == 1) {
                return true;
            }
        }
        return false;
    }
}
