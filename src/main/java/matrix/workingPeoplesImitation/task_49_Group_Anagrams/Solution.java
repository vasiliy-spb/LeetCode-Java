package matrix.workingPeoplesImitation.task_49_Group_Anagrams;

import java.util.*;

public class Solution {

    // my solution
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer,List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] chars = new int[26];
            char[] word = str.toCharArray();
            for (char ch : word)
                chars[ch - 'a']++;
            // If the hash code is not present in the map, create a new list and associate it with the hash code.
            // Then, add the current word to the list of anagrams.
            map.computeIfAbsent(Arrays.hashCode(chars), key -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    // from walkccc.me
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> keyToAnagrams = new HashMap<>();

        for (final String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            keyToAnagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(keyToAnagrams.values());
    }


}
