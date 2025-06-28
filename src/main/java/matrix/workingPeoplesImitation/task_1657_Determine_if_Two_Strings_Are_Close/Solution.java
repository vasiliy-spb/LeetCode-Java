package matrix.workingPeoplesImitation.task_1657_Determine_if_Two_Strings_Are_Close;

import java.util.*;

public class Solution {

    // my solution (as daily task)
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            map1.merge(word1.charAt(i), 1, Integer::sum);
            map2.merge(word2.charAt(i), 1, Integer::sum);
        }
        if (!map1.keySet().equals(map2.keySet())) return false;
        List<Integer> values1 = new ArrayList<>(map1.values());
        List<Integer> values2 = new ArrayList<>(map2.values());
        Collections.sort(values1);
        Collections.sort(values2);
        return values1.equals(values2);
    }

    // my solution (as usual task)
    public boolean closeStrings1(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            map1.merge(word1.charAt(i), 1, Integer::sum);
            map2.merge(word2.charAt(i), 1, Integer::sum);
        }
        if (!map1.keySet().equals(map2.keySet())) return false;
        Map<Integer, Integer> valuesMap = new HashMap<>();
        for (int i : map1.values())
            valuesMap.merge(i, 1, Integer::sum);
        for (int j : map2.values()) {
            if (!valuesMap.containsKey(j)) return false;
            if (valuesMap.get(j) > 1) {
                valuesMap.put(j, valuesMap.get(j) - 1);
            } else {
                valuesMap.remove(j);
            }
        }
        return valuesMap.isEmpty();
    }


    // from walkccc.me
    public boolean closeStrings2(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();

        for (final char c : word1.toCharArray())
            count1.merge(c, 1, Integer::sum);

        for (final char c : word2.toCharArray())
            count2.merge(c, 1, Integer::sum);

        if (!count1.keySet().equals(count2.keySet()))
            return false;

        List<Integer> freqs1 = new ArrayList<>(count1.values());
        List<Integer> freqs2 = new ArrayList<>(count2.values());

        Collections.sort(freqs1);
        Collections.sort(freqs2);
        return freqs1.equals(freqs2);
    }

    // from leetcode solutions
    public boolean closeStrings3(String word1, String word2) {
        // count the English letters
        int N = 26;
        int[] arr1 = new int[N], arr2 = new int[N];
        for (char ch : word1.toCharArray())
            arr1[ch - 'a']++;
        for (char ch : word2.toCharArray())
            arr2[ch - 'a']++;

        // if one has a letter which another one doesn't have, dont exist
        for (int i = 0; i < N; i++) {
            if (arr1[i] == arr2[i]) {
                continue;
            }
            if (arr1[i] == 0 || arr2[i] == 0) {
                return false;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < N; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
