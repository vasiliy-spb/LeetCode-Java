package matrix.workingPeoplesImitation.task_3_Longest_Substring_Without_Repeating_Characters;

import java.util.*;

public class Solution {

    // my solution
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (charSet.contains(ch)) {
                maxLength = Math.max(maxLength, charSet.size());
                do {
                    charSet.remove(s.charAt(j));
                } while (s.charAt(j++) != ch);
            }
            charSet.add(ch);
        }
        return Math.max(maxLength, charSet.size());
    }

    // from leetcode solutions
    public int lengthOfLongestSubstring2(String s) {
        int result = 0;
        int[] cache = new int[256];
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
            cache[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }

    // from leetcode solutions
    public int lengthOfLongestSubstring3(String s) {
        int maxLen = 0;
        Set<Character> window = new HashSet<>();

        int left = 0, right = 0;
        while(right < s.length()) {
            while(window.contains(s.charAt(right)))
                window.remove(s.charAt(left++));
            window.add(s.charAt(right++));
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }

    // from leetcode solutions
    public int lengthOfLongestSubstring4(String s) {
        Queue<Character> queue = new LinkedList<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.offer(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }

    // from walkccc.me (Approach 1: Sliding window)
    public int lengthOfLongestSubstring5(String s) {
        int ans = 0;
        int[] count = new int[128];

        for (int l = 0, r = 0; r < s.length(); ++r) {
            ++count[s.charAt(r)];
            while (count[s.charAt(r)] > 1)
                --count[s.charAt(l++)];
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }

    // from walkccc.me (Approach 2: Last seen)
    public int lengthOfLongestSubstring6(String s) {
        int ans = 0;
        // The substring s[j + 1..i] has no repeating characters.
        int j = -1;
        // lastSeen[c] := the index of the last time c appeared
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);

        for (int i = 0; i < s.length(); ++i) {
            // Update j to lastSeen[s.charAt(i)], so the window must start from j + 1.
            j = Math.max(j, lastSeen[s.charAt(i)]);
            ans = Math.max(ans, i - j);
            lastSeen[s.charAt(i)] = i;
        }

        return ans;
    }

}
