package matrix.workingPeoplesImitation.task_1768_Merge_Strings_Alternately;

public class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int n = Math.min(word1.length(), word2.length());
        for (int i = 0; i < n; i++) {
            if (word1.length() > i) result.append(word1.charAt(i));
            if (word2.length() > i) result.append(word2.charAt(i));
        }
        if (n < word1.length()) result.append(word1.substring(n));
        if (n < word2.length()) result.append(word2.substring(n));
        return result.toString();
    }
}