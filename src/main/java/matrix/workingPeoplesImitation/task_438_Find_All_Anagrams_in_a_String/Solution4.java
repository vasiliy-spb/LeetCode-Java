package matrix.workingPeoplesImitation.task_438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.List;

// from leetcode code sample (2)
public class Solution4 {
    // Copy of LeetCode fastest
    public static List<Integer> findAnagrams(final String s, final String p) {
        final char[] pChars = p.toCharArray();
        final int[] pCharFreq = new int[128];

        // Hash table of p char counts
        for (var c : pChars) {
            ++pCharFreq[c];
        }

        final List<Integer> indexes = new ArrayList<>();
        final char[] sChars = s.toCharArray();
        int start = 0, end = 0, letters = pChars.length;
        while (end <= (sChars.length - letters)) {
            var c = sChars[end];

            if (0 == pCharFreq[c]) {
                // Found an invalid character
                if (letters < pChars.length) {
                    // Recover letters earlier in the string
                    ++pCharFreq[sChars[start]];
                    ++letters;
                } else {
                    // Not in a word yet; advance the end pointer
                    ++end;
                }
                ++start;
                continue;
            }

            ++end;
            --pCharFreq[c];

            // Found a match; recover a letter
            // and advance the start pointer
            if (0 == --letters) {
                indexes.add(start);
                ++pCharFreq[sChars[start]];
                ++start;
                ++letters;
            }
        }

        return indexes;
    }
}
