package matrix.workingPeoplesImitation.task_423_Reconstruct_Original_Digits_from_English;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// my solution
public class Solution {
    public String originalDigits(String s) {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        String[] words = {"zero", "two", "six", "eight", "three", "four", "five", "seven", "nine", "one"};
        int[] order = {0, 2, 6, 8, 3, 4, 5, 7, 9, 1};
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int count = makeUpWord(word, frequency);
            while (count-- > 0) {
                ans.add(order[i]);
            }
        }

        return ans.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private int makeUpWord(String word, int[] frequency) {
        int[] wordFrequency = new int[26];
        for (int i = 0; i < word.length(); i++) {
            wordFrequency[word.charAt(i) - 'a']++;
        }

        int count = Integer.MAX_VALUE;
        for (char ch : word.toCharArray()) {
            count = Math.min(count, frequency[ch - 'a'] / wordFrequency[ch - 'a']);
        }

        if (count > 0 && count < Integer.MAX_VALUE) {
            for (int i = 0; i < wordFrequency.length; i++) {
                frequency[i] -= wordFrequency[i] * count;
            }
        }
        return count;
    }
}
