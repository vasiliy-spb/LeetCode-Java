package matrix.workingPeoplesImitation.task_1844_Replace_All_Digits_with_Characters;

// from walkccc.me
public class Solution2 {
    public String replaceDigits(String s) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i += 2)
            chars[i] += chars[i - 1] - '0';
        return String.valueOf(chars);
    }
}
