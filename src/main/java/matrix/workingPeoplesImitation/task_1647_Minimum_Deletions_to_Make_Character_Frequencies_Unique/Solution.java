package matrix.workingPeoplesImitation.task_1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique;

import java.util.HashSet;
import java.util.Set;

// my solution (fastest)
public class Solution {
    public int minDeletions(String s) {
        int[] frequencies = new int[26];
        for (char ch : s.toCharArray()) {
            frequencies[ch - 'a']++;
        }
        int countDeletions = 0;
        Set<Integer> busy = new HashSet<>();
        for (int frequency : frequencies) {
            while (frequency > 0 && busy.contains(frequency)) {
                countDeletions++;
                frequency--;
            }
            busy.add(frequency);
        }
        return countDeletions;
    }
}
