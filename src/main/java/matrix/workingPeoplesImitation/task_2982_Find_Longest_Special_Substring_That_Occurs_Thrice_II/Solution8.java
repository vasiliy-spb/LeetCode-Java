package matrix.workingPeoplesImitation.task_2982_Find_Longest_Special_Substring_That_Occurs_Thrice_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// from leetcode solutions (1)
// https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-ii/solutions/4484591/java-easy-to-understand-intuitive-hashmap-sort-step-by-step-easy-explanation/
public class Solution8 {
    public int maximumLength(String s) {
        int N = s.length();
        // Use a Map to store the occurrences of characters in the string
        Map<Character, List<Integer>> lookup = new HashMap<>();
        // Iterate through consecutive groups of characters in the string
        // O(N) time
        for (int i = 0; i < N; ) {
            char v = s.charAt(i);
            List<Integer> group = new ArrayList<>();
            // Count consecutive occurrences of the same character
            while (i < N && s.charAt(i) == v) {
                group.add(i);
                i++;
            }
            // Store the length of each group in the lookup map
            lookup.put(v, group);
        }
        int best = -1;
        // Iterate through the characters in the lookup map
        // O(A) time, where A is the number of unique characters in the string
        for (char c : lookup.keySet()) {
            List<Integer> occurrences = lookup.get(c);
            // Sort the occurrences in descending order
            occurrences.sort((a, b) -> Integer.compare(b, a));
            int M = occurrences.size();
            // Check the top 3 occurrences and update the best result
            if (M >= 1)
                best = Math.max(best, occurrences.get(0) - 2);
            if (M >= 2)
                best = Math.max(best, Math.min(occurrences.get(1), occurrences.get(0) - 1));
            if (M >= 3)
                best = Math.max(best, Math.min(occurrences.get(2), Math.min(occurrences.get(1), occurrences.get(0))));
        }
        // If no valid substring is found, return -1
        if (best <= 0)
            return -1;
        return best;
    }
}
