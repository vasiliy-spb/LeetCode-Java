package matrix.workingPeoplesImitation.task_890_Find_and_Replace_Pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// my solution
public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        Map<Character, Integer> patternMap = new HashMap<>();
        for (char ch : pattern.toCharArray()) {
            patternMap.merge(ch, 1, Integer::sum);
        }
        List<String> ans = new ArrayList<>();
        w: for (String word : words) {
            Map<Character, Integer> wordMap = new HashMap<>();
            for (char ch : word.toCharArray()) {
                wordMap.merge(ch, 1, Integer::sum);
            }
            for (int i = 0; i < word.length(); i++) {
                char wChar = word.charAt(i);
                char pChar = pattern.charAt(i);
                if (wordMap.get(wChar) != patternMap.get(pChar) || word.indexOf(wChar) != pattern.indexOf(pChar) || word.lastIndexOf(wChar) != pattern.lastIndexOf(pChar)) {
                    continue w;
                }
            }
            ans.add(word);
        }
        return ans;
    }
}
