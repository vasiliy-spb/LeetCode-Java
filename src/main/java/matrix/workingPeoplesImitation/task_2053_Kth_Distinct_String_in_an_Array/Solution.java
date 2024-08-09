package matrix.workingPeoplesImitation.task_2053_Kth_Distinct_String_in_an_Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    // my solution
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.merge(s, 1, Integer::sum);
        }
        for (String s : arr) {
            if (map.get(s) == 1) {
                k--;
            }
            if (k == 0) {
                return s;
            }
        }
        return "";
    }

    // from leetcode editorial (Approach 2: Hash Set)
    public String kthDistinct2(String[] arr, int k) {
        Set<String> distinctStrings = new HashSet<>();
        Set<String> duplicateStrings = new HashSet<>();

        // First pass: Identify distinct and duplicate strings
        for (String str : arr) {
            // If the string is already in duplicateStrings, skip further processing
            if (duplicateStrings.contains(str)) {
                continue;
            }
            // If the string is in distinctStrings, it means we have seen it before,
            // so move it to duplicateStrings
            if (distinctStrings.contains(str)) {
                distinctStrings.remove(str);
                duplicateStrings.add(str);
            } else {
                distinctStrings.add(str);
            }
        }

        // Second pass: Find the k-th distinct string
        for (String str : arr) {
            if (!duplicateStrings.contains(str)) {
                // Decrement k for each distinct string encountered
                k--;
            }
            // When k reaches 0, we have found the k-th distinct string
            if (k == 0) {
                return str;
            }
        }

        return "";
    }

    // from walkccc.me
    public String kthDistinct3(String[] arr, int k) {
        Map<String, Integer> count = new HashMap<>();

        for (final String a : arr)
            count.merge(a, 1, Integer::sum);

        for (final String a : arr)
            if (count.get(a) == 1 && --k == 0)
                return a;

        return "";
    }

}
