package matrix.workingPeoplesImitation.task_409_Longest_Palindrome;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // my solution
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }
        int length = 0;
        int maxEven = 0;
        for (int num : map.values()) {
            if (num % 2 == 0) length += num;
            else {
                length += num - 1;
                maxEven = 1;
            }
        }
        return length + maxEven;
    }

    // from walkccc.me
    public int longestPalindrome2(String s) {
        int ans = 0;
        int[] count = new int[128];

        for (final char c : s.toCharArray())
            ++count[c];

        for (final int freq : count)
            ans += freq % 2 == 0 ? freq : freq - 1;

        final boolean hasOddCount = Arrays.stream(count).anyMatch(freq -> freq % 2 == 1);
        return ans + (hasOddCount ? 1 : 0);
    }

}
