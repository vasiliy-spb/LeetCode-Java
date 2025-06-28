package matrix.workingPeoplesImitation.task_1071_Greatest_Common_Divisor_of_Strings;

public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        int i = 0;
        while (i < str1.length() && i < str2.length()) {
            if (str1.charAt(i) == str2.charAt(i)) {
                current.append(str1.charAt(i++));
                if (str1.length() % current.length() == 0 && str2.length() % current.length() == 0) result = new StringBuilder(current);
            } else break;
        }
        if (!str1.replaceAll(result.toString(), "").isEmpty()
                || !str2.replaceAll(result.toString(), "").isEmpty())
            return "";
        return result.toString();
    }

    // from walkccc.me
    public String gcdOfStrings2(String str1, String str2) {
        if (str1.length() < str2.length())
            return gcdOfStrings2(str2, str1);
        if (!str1.startsWith(str2))
            return "";
        if (str2.isEmpty())
            return str1;
        return gcdOfStrings2(str2, mod(str1, str2));
    }

    private String mod(String s1, final String s2) {
        while (s1.startsWith(s2))
            s1 = s1.substring(s2.length());
        return s1;
    }

}
