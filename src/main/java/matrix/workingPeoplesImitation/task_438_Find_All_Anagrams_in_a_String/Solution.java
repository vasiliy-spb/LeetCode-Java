package matrix.workingPeoplesImitation.task_438_Find_All_Anagrams_in_a_String;

import java.util.*;

// my solution
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> ans = new ArrayList<>();
        if (n < m) {
            return ans;
        }
        int[] letters = new int[26];
        int left = 0;
        int right = 0;
        while(right < m) {
            letters[s.charAt(right) - 'a']++;
            letters[p.charAt(right++) - 'a']--;
        }
        while (right < n) {
            if (canMakeAnagram(letters)) {
                ans.add(left);
            }
            letters[s.charAt(right++) - 'a']++;
            letters[s.charAt(left++) - 'a']--;
        }
        if (canMakeAnagram(letters)) {
            ans.add(left);
        }
        return ans;
    }

    private boolean canMakeAnagram(int[] letters) {
        return Arrays.stream(letters).allMatch(a -> a == 0);
    }

    public List<Integer> findAnagrams0(String s, String p) {
        int n = s.length();
        int m = p.length();
        if (n < m) {
            return new ArrayList<>();
        }
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (right = 0; right < m; right++) {
            pMap.merge(p.charAt(right), 1, Integer::sum);
            sMap.merge(s.charAt(right), 1, Integer::sum);
        }
        while (right < n) {
            if (canMakeAnagram(sMap, pMap)) {
//            if (sMap.equals(pMap)) {
                ans.add(left);
            }
            sMap.merge(s.charAt(right++), 1, Integer::sum);
            sMap.merge(s.charAt(left), -1, Integer::sum);
            if (sMap.get(s.charAt(left)) == 0) {
                sMap.remove(s.charAt(left));
            }
            left++;
        }
        if (canMakeAnagram(sMap, pMap)) {
//        if (sMap.equals(pMap)) {
            ans.add(left);
        }
        return ans;
    }
    private boolean canMakeAnagram(Map<Character, Integer> sMap, Map<Character, Integer> pMap) {
        for (char ch : sMap.keySet()) {
            if ((int) sMap.getOrDefault(ch, 0) != pMap.getOrDefault(ch, 0)) {
                return false;
            }
        }
        return true;
    }
}
