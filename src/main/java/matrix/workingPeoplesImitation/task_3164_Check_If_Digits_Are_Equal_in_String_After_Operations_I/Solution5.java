package matrix.workingPeoplesImitation.task_3164_Check_If_Digits_Are_Equal_in_String_After_Operations_I;

// from leetcode code sample (1)
public class Solution5 {
    public boolean hasSameDigits(String s) {
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1);
        }
        char[] charArray = new char[s.length() - 1];
        for (int i = 0; i < s.length() - 1; i++) {
            int first = s.charAt(i) - '0';
            int second = s.charAt(i + 1) - '0';
            int diff = (second + first) % 10;
            char nchar = (char) (diff + '0');
            charArray[i] = nchar;
        }
        String str = String.valueOf(charArray);
        return hasSameDigits(str);
    }
}
