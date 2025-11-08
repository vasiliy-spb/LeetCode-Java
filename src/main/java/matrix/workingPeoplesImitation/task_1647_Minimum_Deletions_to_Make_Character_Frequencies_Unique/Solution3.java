package matrix.workingPeoplesImitation.task_1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// my solution
public class Solution3 {
    public int minDeletions(String s) {
        int[] frequencies = new int[26];
        for (char ch : s.toCharArray()) {
            frequencies[ch - 'a']++;
        }
        Arrays.sort(frequencies);
        int countDeletions = 0;
        int prev = s.length() + 1;
        for (int i = 25; i >= 0; i--) {
            int frequency = frequencies[i];
            while (frequency > 0 && frequency >= prev) {
                countDeletions++;
                frequency--;
            }
            prev = frequency;
        }
        return countDeletions;
    }
}
