package matrix.workingPeoplesImitation.task_438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// from leetcode code sample (4)
public class Solution6 {
    public List<Integer> findAnagrams(String s, String p) {
        // Initialize the length of both strings
        int stringLength = s.length(), patternLength = p.length();
        List<Integer> anagramsStartIndices = new ArrayList<>();

        // If the pattern is longer than the string, no anagrams can be found
        if (stringLength < patternLength) {
            return anagramsStartIndices;
        }

        // Count the frequency of characters in the pattern
        int[] patternCount = new int[26];
        for (int i = 0; i < patternLength; ++i) {
            patternCount[p.charAt(i) - 'a']++;
        }

        // Initialize character frequency counter for window in 's'
        int[] windowCount = new int[26];
        // Initialize the window with the first (patternLength - 1) characters
        for (int i = 0; i < patternLength - 1; ++i) {
            windowCount[s.charAt(i) - 'a']++;
        }

        // Slide the window across the string 's' one character at a time
        for (int i = patternLength - 1; i < stringLength; ++i) {
            // Add the new character to the window
            windowCount[s.charAt(i) - 'a']++;

            // If the window matches the pattern counts, record the start index
            if (Arrays.equals(patternCount, windowCount)) {
                anagramsStartIndices.add(i - patternLength + 1);
            }

            // Remove the leftmost (oldest) character from the window
            windowCount[s.charAt(i - patternLength + 1) - 'a']--;
        }

        return anagramsStartIndices;
    }
}
