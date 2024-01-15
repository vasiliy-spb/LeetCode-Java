package matrix.workingPeoplesImitation.task_1456_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int maxVowels(String s, int k) {
//        Set<Character> chars = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Set<Character> chars = Set.of('a', 'e', 'i', 'o', 'u');
        int maxCount = 0;
        int currentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (chars.contains(s.charAt(i))) currentCount++;
            if (i >= k && chars.contains(s.charAt(i - k))) currentCount--;
            maxCount = Math.max(maxCount, currentCount);
        }
        return maxCount;
    }

    // from walkccc.me
    public int maxVowels1(String s, int k) {
        int ans = 0;
        int maxi = 0;
        String kVowels = "aeiou";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (kVowels.indexOf(c) != -1) {
                maxi += 1;
            }
            if (i >= k && kVowels.indexOf(s.charAt(i - k)) != -1) {
                maxi -= 1;
            }
            ans = Math.max(ans, maxi);
        }

        return ans;
    }

    // from GPT
    public int maxVowels3(String s, int k) {
        int ans = 0;
        int maxi = 0;
        String kVowels = "aeiou";

        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            if (kVowels.indexOf(c) != -1) {
                maxi += 1;
            }
        }

        ans = maxi;

        for (int i = k; i < s.length(); i++) {
            char c = s.charAt(i);
            char firstChar = s.charAt(i - k);

            if (kVowels.indexOf(c) != -1) {
                maxi += 1;
            }
            if (kVowels.indexOf(firstChar) != -1) {
                maxi -= 1;
            }

            ans = Math.max(ans, maxi);
        }

        return ans;
    }
}
