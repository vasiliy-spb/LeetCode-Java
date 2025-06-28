package matrix.workingPeoplesImitation.task_3035_Maximum_Palindromes_After_Operations;

import java.util.Arrays;

public class Solution {

    // my solution
    public int maxPalindromesAfterOperations(String[] words) {
        int[] frequency = new int[26];
        for (String word : words)
            for (int i = 0; i < word.length(); i++)
                frequency[word.charAt(i) - 'a']++;
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        int countEvenPair = 0;
        for (int frec : frequency) {
            countEvenPair += frec / 2;
        }
        int palindrome = 0;
        for (int i = 0; i < words.length; i++) {
            countEvenPair -= words[i].length() / 2;
            if (countEvenPair < 0) break;
            palindrome++;
        }
        return palindrome;
    }

    // my solution
    public int maxPalindromesAfterOperations0(String[] words) {
        int[] frequency = new int[26];
        for (String word : words)
            for (int i = 0; i < word.length(); i++)
                frequency[word.charAt(i) - 'a']++;
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        int countOdd = 0;
        int countEvenPair = 0;
        for (int frec : frequency) {
            if (frec % 2 != 0) countOdd++;
            countEvenPair += frec / 2;
        }
        int palindrome = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() % 2 != 0) {
                countOdd--;
            }
            countEvenPair -= words[i].length() / 2;
            if (countEvenPair < 0) {
                break;
            }
            palindrome++;
        }
        return palindrome;
    }

}
