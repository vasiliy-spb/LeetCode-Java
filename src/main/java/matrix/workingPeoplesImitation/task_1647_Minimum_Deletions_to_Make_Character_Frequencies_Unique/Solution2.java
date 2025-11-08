package matrix.workingPeoplesImitation.task_1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

// my solution
public class Solution2 {
    public int minDeletions(String s) {
        int[] frequencies = new int[26];
        for (char ch : s.toCharArray()) {
            frequencies[ch - 'a']++;
        }
        Arrays.sort(frequencies);
        int countDeletions = 0;
        for (int i = 24; i >= 0; i--) {
            if (frequencies[i + 1] == 0) {
                countDeletions += frequencies[i];
                frequencies[i] = 0;
            } else if (frequencies[i] >= frequencies[i + 1]) {
                countDeletions += frequencies[i] - frequencies[i + 1] + 1;
                frequencies[i] = Math.max(0, frequencies[i + 1] - 1);
            }
        }
        return countDeletions;
    }
}
