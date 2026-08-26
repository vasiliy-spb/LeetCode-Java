package matrix.workingPeoplesImitation.task_2904_Shortest_and_Lexicographically_Smallest_Beautiful_String;

// from leetcode editorial (Approach 2: Sliding Window)
public class Solution3 {
    public String shortestBeautifulSubstring(String s, int k) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) total += s.charAt(i) - '0';
        if (total < k) return "";
        String ans = s;
        int cnt = 0,
                left = 0;
        for (int right = 0; right < s.length(); right++) {
            cnt += s.charAt(right) - '0';
            while (cnt > k || s.charAt(left) == '0') {
                cnt -= s.charAt(left++) - '0';
            }
            if (cnt == k) {
                String t = s.substring(left, right + 1);
                if (
                        t.length() < ans.length() ||
                        (t.length() == ans.length() && t.compareTo(ans) < 0)
                ) {
                    ans = t;
                }
            }
        }
        return ans;
    }
}
