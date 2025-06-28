package matrix.workingPeoplesImitation.task_76_Minimum_Window_Substring;

import java.util.*;

public class Solution {

    // my solution
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";
//        System.out.println("s = " + s);
//        System.out.println("t = " + t);
        Map<Character, Integer> tMap = new HashMap<>();
        Set<Integer> matchSet = new HashSet<>();
        Map<Character, Integer> sMap = new HashMap<>();
        TreeMap<Integer, int[]> indexMap = new TreeMap<>();
        for (int i = 0; i < t.length(); i++)
            tMap.merge(t.charAt(i), 1, Integer::sum);
        int windowSize = s.length();
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
//            System.out.println("i = " + i);
            if (tMap.containsKey(ch)) {
                if (left == 0) left = i;
                while (matchSet.size() != tMap.size() && i < s.length()) {
//                    System.out.println("matchSet.size == tMap.size = " + false);
                    ch = s.charAt(i++);
//                    System.out.println("ch = " + ch);
                    sMap.merge(ch, 1, Integer::sum);
                    if (tMap.containsKey(ch) && tMap.get(ch).intValue() == sMap.get(ch).intValue())
                        matchSet.add((int) ch);
                }
                right = --i;
                if (matchSet.size() == tMap.size()) indexMap.put(right - left + 1, new int[]{left, right});
//                System.out.println("indexMap.put = " + Arrays.toString(new int[]{left, right}));
            }
            while (matchSet.size() == tMap.size()) {
//                System.out.println("matchSet.size == tMap.size = " + true);
                windowSize = Math.min(windowSize, right - left + 1);
                char leftChar = s.charAt(left++);
//                System.out.println("leftChar = " + leftChar);
                sMap.merge(leftChar, -1, Integer::sum);
                if (tMap.containsKey(leftChar) && sMap.get(leftChar) < tMap.get(leftChar)) {
                    matchSet.remove((int) leftChar);
//                    System.out.println("matchSet.remove = " + leftChar);
                } else {
                    indexMap.put(right - left + 1, new int[]{left, right});
//                    System.out.println("indexMap.put = " + Arrays.toString(new int[]{left, right}));
                }
            }
        }
        Map.Entry<Integer, int[]> entry = indexMap.ceilingEntry(0);
        if (entry == null || entry.getKey() < t.length()) return "";
        int[] indexes = entry.getValue();
//        System.out.println("indexMap = " + indexMap);
//        System.out.println();
        return s.substring(indexes[0], indexes[1] + 1);
    }

    // from walkccc.me
    public String minWindow2(String s, String t) {
        int[] count = new int[128];
        int required = t.length();
        int bestLeft = -1;
        int minLength = s.length() + 1;

        for (final char c : t.toCharArray())
            ++count[c];

        for (int l = 0, r = 0; r < s.length(); ++r) {
            if (--count[s.charAt(r)] >= 0)
                --required;
            while (required == 0) {
                if (r - l + 1 < minLength) {
                    bestLeft = l;
                    minLength = r - l + 1;
                }
                if (++count[s.charAt(l++)] > 0)
                    ++required;
            }
        }

        return bestLeft == -1 ? "" : s.substring(bestLeft, bestLeft + minLength);
    }

}
