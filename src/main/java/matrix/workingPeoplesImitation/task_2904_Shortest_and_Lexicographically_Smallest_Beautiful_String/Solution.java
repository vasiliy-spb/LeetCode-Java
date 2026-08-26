package matrix.workingPeoplesImitation.task_2904_Shortest_and_Lexicographically_Smallest_Beautiful_String;

// my solution
public class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        String ans = s + "0";
        while (right < s.length()) {
            count += s.charAt(right++) == '1' ? 1 : 0;
            while (count == k) {
                String candidate = s.substring(left, right);
                if (candidate.length() < ans.length() || candidate.length() == ans.length() && isLexicographicallyOrder(candidate, ans)) {
                    ans = candidate;
                }
                count -= s.charAt(left++) == '1' ? 1 : 0;
            }
        }
        return ans.length() > s.length() ? "" : ans;
    }

    private boolean isLexicographicallyOrder(String first, String second) {
        for (int i = 0; i < first.length(); i++) {
            if (second.charAt(i) != first.charAt(i)) {
                return second.charAt(i) > first.charAt(i);
            }
        }
        return true;
    }
}
