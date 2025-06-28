package matrix.workingPeoplesImitation.task_792_Number_of_Matching_Subsequences;

import java.util.HashSet;
import java.util.Set;

// my solution
public class Solution2 {
    // accepted
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        Set<String> set = new HashSet<>();
        for (String word : words) {
            if (set.contains(word)) {
                count++;
                continue;
            }
            int index = 0;
            int i = 0;
            int next = 0;
            do {
                next = s.indexOf(word.charAt(index), i);
                i = next + 1;
                if (next >= 0) {
                    index++;
                }
            } while (next >= 0 && index < word.length());
            if (index == word.length()) {
                count++;
                set.add(word);
            }
        }
        return count;
    }

    // TLE
    public int numMatchingSubseq0(String s, String[] words) {
        int count = 0;
        Set<String> set = new HashSet<>();
        for (String word : words) {
            if (set.contains(word)) {
                count++;
                continue;
            }
            int index = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == word.charAt(index)) {
                    index++;
                    if (index == word.length()) {
                        count++;
                        set.add(word);
                        break;
                    }
                }
            }
        }
        return count;
    }
}
