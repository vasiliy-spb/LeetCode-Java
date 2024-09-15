package matrix.workingPeoplesImitation.task_859_Buddy_Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        Set<Character> setS = s.chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet());
        Set<Character> setG = goal.chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet());
        if (!setS.equals(setG)) {
            return false;
        }
        int diffCount = 0;
        int[] diff = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char gChar = goal.charAt(i);
            if (sChar != gChar) {
                diffCount++;
                diff[sChar - 'a']++;
                diff[gChar - 'a']--;
            }
        }
        if (diffCount > 2) {
            return false;
        }
        return Arrays.stream(diff).filter(d -> d != 0).count() == 0 && (setS.size() < s.length() || diffCount == 2);
    }
    public boolean buddyStrings0(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }
        boolean findDiff = false;
        char prevS = '\0';
        char prevG = '\0';
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char gChar = goal.charAt(i);
            if (sChar != gChar) {
                findDiff = true;
                if (prevS == '_') {
                    return false;
                }
                if (prevS == '\0') {
                    prevS = sChar;
                    prevG = gChar;
                } else {
                    if (gChar != prevS || sChar != prevG) {
                        return false;
                    } else {
                        prevS = '_';
                        prevG = '_';
                    }
                }
            }
        }
        return findDiff ? prevS == '_' : s.length() != set.size();
    }
}
