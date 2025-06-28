package matrix.workingPeoplesImitation.task_1371_Find_the_Longest_Substring_Containing_Vowels_in_Even_Counts;

// from leetcode code sample (3)
public class Solution6 {
    private static final int[] VOWEL_MASK = new int[128];
    static {
        VOWEL_MASK['a'] = 1;  // 00001
        VOWEL_MASK['e'] = 2;  // 00010
        VOWEL_MASK['i'] = 4;  // 00100
        VOWEL_MASK['o'] = 8;  // 01000
        VOWEL_MASK['u'] = 16; // 10000
    }

    public int findTheLongestSubstring(String s) {
        // To store the first occurrence of each bitmask (0 to 31)
        int[] firstOccurrence = new int[32];
        java.util.Arrays.fill(firstOccurrence, -1);
        firstOccurrence[0] = 0; // Bitmask 0 occurs at position -1 (before the string starts)

        int maxLength = 0;
        int mask = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Update mask if it's a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                mask ^= VOWEL_MASK[ch];
            }

            // If the current mask was seen before, calculate the length of the substring
            if (firstOccurrence[mask] != -1) {
                maxLength = Math.max(maxLength, i + 1 - firstOccurrence[mask]);
            } else {
                // Store the first occurrence of this bitmask
                firstOccurrence[mask] = i + 1;
            }
        }

        return maxLength;
    }
}
