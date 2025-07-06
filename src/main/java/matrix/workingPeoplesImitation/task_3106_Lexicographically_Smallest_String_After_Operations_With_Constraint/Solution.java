package matrix.workingPeoplesImitation.task_3106_Lexicographically_Smallest_String_After_Operations_With_Constraint;

// my solution
public class Solution {
    public String getSmallestString(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (k == 0) {
                break;
            }
            int current = chars[i] - 'a';

            if (current == 0) {
                continue;
            }

            if (current <= 13) {
                if (k >= current) {
                    k -= current;
                    current = 0;
                } else {
                    current -= k;
                    k = 0;
                }
            } else {
                if (k >= 26 - current) {
                    k -= 26 - current;
                    current = 0;
                } else {
                    current -= k;
                    k = 0;
                }
            }
            chars[i] = (char) ('a' + current);
        }
        return new String(chars);
    }
}
