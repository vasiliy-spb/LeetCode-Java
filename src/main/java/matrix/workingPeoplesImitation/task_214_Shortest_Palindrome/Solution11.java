package matrix.workingPeoplesImitation.task_214_Shortest_Palindrome;

// from leetcode code sample (4)
public class Solution11 {
    public String shortestPalindrome(String s) {
        int i = 0;
        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(j) == s.charAt(i)) {
                i++;
            }
        }
        if (i == s.length()) {
            return s;
        }
        // (we have to add the suffix at front that stopping it from becoming palindorme)
        // eg- abadz -> zdabadz (added zd in preffix as suffix dz is not letting it be a palind)
        // divide the string till i
        String suffix = s.substring(i);
        StringBuilder sb = new StringBuilder(suffix);
        sb.reverse().toString();

        // we have to find the shortest palindrome so recursive call it
        return sb + shortestPalindrome(s.substring(0, i)) + suffix;
    }
}
