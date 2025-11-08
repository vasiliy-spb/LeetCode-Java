package matrix.workingPeoplesImitation.task_1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique;

import java.util.HashSet;
import java.util.Set;

// from walkccc.me
public class Solution4 {
    public int minDeletions(String s) {
        int ans = 0;
        int[] count = new int[26];
        Set<Integer> usedFreq = new HashSet<>();

        for (final char c : s.toCharArray()) {
            ++count[c - 'a'];
        }

        for (int freq : count) {
            while (freq > 0 && usedFreq.contains(freq)) {
                --freq; // Delete ('a' + i).
                ++ans;
            }
            usedFreq.add(freq);
        }

        return ans;
    }
}
