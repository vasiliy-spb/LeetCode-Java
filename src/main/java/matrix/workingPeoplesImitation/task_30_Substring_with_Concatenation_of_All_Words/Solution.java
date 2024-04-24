package matrix.workingPeoplesImitation.task_30_Substring_with_Concatenation_of_All_Words;

import java.util.*;

public class Solution {

    // my solution
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> dictionary = new HashMap<>();
        Arrays.stream(words).forEach(word -> dictionary.merge(word, 1, Integer::sum));
        int simpleWordLength = words[0].length();
        int concatenatedWordLength = simpleWordLength * words.length;
        if (s.length() < concatenatedWordLength) return new ArrayList<>();
        StringBuilder currentWord = new StringBuilder(s.substring(0, concatenatedWordLength));
        List<Integer> result = new ArrayList<>();
        for (int i = concatenatedWordLength; i < s.length(); i++) {
            if (containsFullDictionary(currentWord, new HashMap<>(dictionary), simpleWordLength))
                result.add(i - concatenatedWordLength);
            currentWord.deleteCharAt(0);
            currentWord.append(s.charAt(i));
        }
        if (containsFullDictionary(currentWord, new HashMap<>(dictionary), simpleWordLength))
            result.add(s.length() - concatenatedWordLength);
        return result;
    }

    private boolean containsFullDictionary(StringBuilder currentWord, Map<String, Integer> dictionary, int simpleWordLength) {
        int start = 0;
        int end = simpleWordLength;
        while (start < currentWord.length()) {
            String word = currentWord.substring(start, end);
            if (dictionary.containsKey(word) && dictionary.get(word) > 0) dictionary.merge(word, -1, Integer::sum);
            else return false;
            start += simpleWordLength;
            end += simpleWordLength;
        }
        return true;
    }

    // from walkccc.me
    public List<Integer> findSubstring2(String s, String[] words) {
        if (s.isEmpty() || words.length == 0)
            return new ArrayList<>();

        final int k = words.length;
        final int n = words[0].length();
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();

        for (final String word : words)
            count.merge(word, 1, Integer::sum);

        for (int i = 0; i <= s.length() - k * n; ++i) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            for (; j < k; ++j) {
                final String word = s.substring(i + j * n, i + j * n + n);
                seen.merge(word, 1, Integer::sum);
                if (seen.get(word) > count.getOrDefault(word, 0))
                    break;
            }
            if (j == k)
                ans.add(i);
        }

        return ans;
    }

    // from GPT (with backtracking) 151 / 179 testcases passed then TLE
    public List<Integer> findSubstring3(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalWords = words.length;
        int concatLength = wordLength * totalWords;

        // Preprocess words to generate all possible concatenated words
        Set<String> concatWords = new HashSet<>();
        generateConcatenatedWords(words, concatWords, new boolean[words.length], new StringBuilder(), 0);

        // Iterate through each substring of length concatLength
        for (int i = 0; i <= s.length() - concatLength; i++) {
            String sub = s.substring(i, i + concatLength);
            // Check if the substring is in the set of concatenated words
            if (concatWords.contains(sub)) {
                result.add(i);
            }
        }

        return result;
    }

    // Helper method to generate all possible concatenated words
    private void generateConcatenatedWords(String[] words, Set<String> concatWords, boolean[] used, StringBuilder current, int count) {
        if (count == words.length) {
            concatWords.add(current.toString());
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.append(words[i]);
                generateConcatenatedWords(words, concatWords, used, current, count + 1);
                current.delete(current.length() - words[i].length(), current.length());
                used[i] = false;
            }
        }
    }

}
