package matrix.workingPeoplesImitation.task_784_Letter_Case_Permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// my solution
public class Solution {

    // Backtracking
    public List<String> letterCasePermutation(String s) {
        Set<String> set = new HashSet<>();
        backtrack(new StringBuilder(s.toLowerCase()), 0, set);
        return set.stream().toList();
    }

    private void backtrack(StringBuilder stringBuilder, int index, Set<String> set) {
        set.add(stringBuilder.toString());
        if (index == stringBuilder.length()) {
            return;
        }
        for (int i = index; i < stringBuilder.length(); i++) {
            if (!Character.isLetter(stringBuilder.charAt(i))) {
                continue;
            }
            stringBuilder.setCharAt(i, Character.toUpperCase(stringBuilder.charAt(i)));
            backtrack(stringBuilder, i + 1, set);
            stringBuilder.setCharAt(i, Character.toLowerCase(stringBuilder.charAt(i)));
        }
    }

    // Bit manipulation
    public List<String> letterCasePermutation0(String s) {
        s = s.toLowerCase();
        List<Integer> letterIndexList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                letterIndexList.add(i);
            }
        }
        int mask = (int) Math.pow(2, letterIndexList.size());
        List<String> ans = new ArrayList<>();
        while (mask > 0) {
            StringBuilder variableString = new StringBuilder(s);
            int num = mask;
            for (int letterIndex : letterIndexList) {
                if ((num & 1) == 1) {
                    char currentLetter = variableString.charAt(letterIndex);
                    char newLetter = Character.toUpperCase(currentLetter);
                    variableString.setCharAt(letterIndex, newLetter);
                }
                num >>= 1;
            }
            ans.add(variableString.toString());
            mask--;
        }
        return ans;
    }

    // Bit manipulation
    public List<String> letterCasePermutation00(String s) {
        s = s.toLowerCase();
        List<Integer> letterIndexList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch > '9') {
                letterIndexList.add(i);
            }
        }
        int mask = (int) Math.pow(2, letterIndexList.size());
        List<String> ans = new ArrayList<>();
        while (mask > 0) {
            char[] variableString = s.toCharArray();
            int num = mask;
            for (int letterIndex : letterIndexList) {
                if ((num & 1) == 1) {
                    variableString[letterIndex] = Character.toUpperCase(variableString[letterIndex]);
                }
                num >>= 1;
            }
            ans.add(String.valueOf(variableString));
            mask--;
        }
        return ans;
    }
}
