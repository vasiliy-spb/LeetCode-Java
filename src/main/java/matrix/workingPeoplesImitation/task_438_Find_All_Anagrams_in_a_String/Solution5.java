package matrix.workingPeoplesImitation.task_438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// from leetcode code sample (3)
public class Solution5 {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();

        // Base case check
        if (n < m) {
            return new ArrayList<>();
        }

        int[] pfreq = new int[26]; // Frequency array for pattern p
        int[] sfreq = new int[26]; // Frequency array for the sliding window in s

        // Initialize the frequency array for pattern p
        for (int i = 0; i < m; i++) {
            pfreq[p.charAt(i) - 'a']++; // Corrected to use p.charAt(i)
        }

        // Initialize the frequency array for the first window of size m in s
        for (int i = 0; i < m; i++) {
            sfreq[s.charAt(i) - 'a']++;
        }

        List<Integer> list = new ArrayList<>(); // To store the result

        // Start sliding the window over string s
        for (int i = m; i < n; i++) {
            // If the frequency arrays match, add the start index of the window
            if (Arrays.equals(pfreq, sfreq)) {
                list.add(i - m);
            }

            // Include the next character in the window
            sfreq[s.charAt(i) - 'a']++;
            // Exclude the character that is left behind the window
            sfreq[s.charAt(i - m) - 'a']--;
        }

        // Final check for the last window
        if (Arrays.equals(pfreq, sfreq)) {
            list.add(n - m);
        }

        return list;
    }
}

