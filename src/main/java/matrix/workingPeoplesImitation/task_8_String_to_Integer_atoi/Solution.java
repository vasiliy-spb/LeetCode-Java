package matrix.workingPeoplesImitation.task_8_String_to_Integer_atoi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    // my solution 2
    public int myAtoi(String s) {
        s = s.trim();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '-' || ch == '+') {
                stringBuilder.append(ch);
            } else if (Character.isDigit(ch)) {
                while (i < s.length() && s.charAt(i) == '0')
                    i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    stringBuilder.append(s.charAt(i++));
                }
                break;
            } else {
                break;
            }
        }
        if (stringBuilder.length() > 11) {
            if (stringBuilder.charAt(0) == '-') {
                if (Character.isDigit(stringBuilder.charAt(1))) return Integer.MIN_VALUE;
                else return 0;
            } else if (stringBuilder.charAt(0) == '+') {
                if (Character.isDigit(stringBuilder.charAt(1))) return Integer.MAX_VALUE;
                else return 0;
            } else if (Character.isDigit(stringBuilder.charAt(0))) {
                return Integer.MAX_VALUE;
            } else return 0;
        }
        if (stringBuilder.isEmpty()) return 0;
        try {
            long ans = Long.parseLong(stringBuilder.toString());
            if (ans > Integer.MAX_VALUE) ans = Integer.MAX_VALUE;
            if (ans < Integer.MIN_VALUE) ans = Integer.MIN_VALUE;
            return (int) ans;
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }

    // my solution 1
    public int myAtoi1(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("^[ ]*[-/+]?\\d+");
        Matcher matcher = pattern.matcher(s);
        if (!matcher.find()) return 0;

        String number = matcher.group().trim();
        int sign = 1;
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch == '-') sign = -1;
            else if (ch != '0') {
                while (i < number.length()) {
                    stringBuilder.append(number.charAt(i++));
                }
            }
        }
        if (stringBuilder.length() > 11) {
            if (sign < 0) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
        long ans = Long.parseLong(number);
        if (ans > Integer.MAX_VALUE) ans = Integer.MAX_VALUE;
        if (ans < Integer.MIN_VALUE) ans = Integer.MIN_VALUE;
        return (int) ans;
    }

    // from walkccc.me
    public int myAtoi3(String s) {
        s = s.strip();
        if (s.isEmpty())
            return 0;

        final int sign = s.charAt(0) == '-' ? -1 : 1;
        if (s.charAt(0) == '+' || s.charAt(0) == '-')
            s = s.substring(1);

        long num = 0;

        for (final char c : s.toCharArray()) {
            if (!Character.isDigit(c))
                break;
            num = num * 10 + (c - '0');
            if (sign * num <= Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            if (sign * num >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        }

        return sign * (int) num;
    }

    // from leetcode solutions
    public int myAtoi4(String str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
            index ++;

        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }
}
