package matrix.workingPeoplesImitation.task_2734_Lexicographically_Smallest_String_After_Substring_Operation;

// from walkccc.me
public class Solution2 {
    public String smallestString(String s) {
        char[] charArray = s.toCharArray();
        final int n = s.length();
        int i = 0;

        while (i < n && charArray[i] == 'a')
            ++i;
        if (i == n) {
            charArray[n - 1] = 'z';
            return new String(charArray);
        }

        while (i < n && charArray[i] != 'a')
            --charArray[i++];

        return new String(charArray);
    }
}
