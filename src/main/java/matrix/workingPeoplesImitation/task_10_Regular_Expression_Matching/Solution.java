package matrix.workingPeoplesImitation.task_10_Regular_Expression_Matching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    // my solution
    public static boolean isMatch(String s, String p) {
        Pattern pattern2 = Pattern.compile(".*\\*{2}+.*");
        Matcher matcher2 = pattern2.matcher(p);
        while (matcher2.matches()) {
            p = p.replaceAll("\\*\\*", "*");
            matcher2 = pattern2.matcher(p);
        }
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

//    // from editorial
//    public static boolean isMatch(String text, String pattern) {
//        if (pattern.isEmpty()) return text.isEmpty();
//        boolean first_match = (!text.isEmpty() &&
//                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
//
//        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
//            return (isMatch(text, pattern.substring(2)) ||
//                    (first_match && isMatch(text.substring(1), pattern)));
//        } else {
//            return first_match && isMatch(text.substring(1), pattern.substring(1));
//        }
//    }

    public static void main(String[] args) {
        String s = "abc";
        String p = "a***abc";
        System.out.println(isMatch(s, p));
    }
}
