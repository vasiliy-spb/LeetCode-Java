package matrix.workingPeoplesImitation.task_2785_Sort_Vowels_in_a_String;

import java.util.*;

// my solution
public class Solution {
    public String sortVowels(String s) {
        List<Character> vows = new ArrayList<>();
        for (char v : s.toCharArray()) {
            if (isVowel(v)) {
                vows.add(v);
            }
        }
        vows.sort(null);
        int index = 0;
        StringBuilder ans = new StringBuilder();
        for (char v : s.toCharArray()) {
            if (isVowel(v)) {
                ans.append(vows.get(index++));
            } else {
                ans.append(v);
            }
        }
        return ans.toString();
    }
    // проверка через отдельный метод работает чуть быстрее (судя по результатам в leetcode), чем проверка
    // через contains() в сете (Set<Character> vowels = Set.of('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');)
    // или через indexOf() в строке (String vowels = "aAeEiIoOuU";)
    private boolean isVowel(char ch) {
        return ch == 'a' || ch ==  'A' || ch ==  'e' || ch ==  'E' || ch ==  'i' || ch ==  'I' || ch ==  'o' || ch ==  'O' || ch ==  'u' || ch ==  'U';
    }
}
