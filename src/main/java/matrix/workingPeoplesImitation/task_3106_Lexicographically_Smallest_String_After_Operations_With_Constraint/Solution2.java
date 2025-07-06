package matrix.workingPeoplesImitation.task_3106_Lexicographically_Smallest_String_After_Operations_With_Constraint;

// my solution 2
public class Solution2 {
    public String getSmallestString(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length() && k > 0; i++) {
            int current = chars[i] - 'a';
            int distance = current <= 13 ? current : 26 - current;

            if (k >= distance) {
                k -= distance;
                current = 0;
            } else {
                current -= k;
                k = 0;
            }

            chars[i] = (char) ('a' + current);
        }
        return new String(chars);
    }
}
