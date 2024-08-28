package matrix.workingPeoplesImitation.task_2405_Optimal_Partition_of_String;

import java.util.HashSet;
import java.util.Set;

// my solution
public class Solution {
    public int partitionString(String s) {
        boolean[] letters = new boolean[26];
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (letters[ch - 'a']) {
                count++;
                letters = new boolean[26];
            }
            letters[ch - 'a'] = true;
        }
        for (boolean letter : letters) {
            if (letter) {
                count++;
                break;
            }
        }
        return count;
    }
    public int partitionString0(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                count++;
                set = new HashSet<>();
            }
            set.add(ch);
        }
        if (set.size() > 0) {
            count++;
        }
        return count;
    }
}
