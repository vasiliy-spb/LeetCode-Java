package matrix.workingPeoplesImitation.task_1844_Replace_All_Digits_with_Characters;

// my solution
public class Solution {
    public String replaceDigits(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(chars[i])) {
                chars[i] += chars[i - 1] - '0';
            }
        }
        return new String(chars);
    }
}
