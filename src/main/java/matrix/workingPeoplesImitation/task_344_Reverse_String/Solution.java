package matrix.workingPeoplesImitation.task_344_Reverse_String;

public class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            s[l] += s[r];
            s[r] = (char) (s[l] - s[r]);
            s[l++] -= s[r--];
        }
    }
}
