package matrix.workingPeoplesImitation.task_394_Decode_String;

public class Solution {

    // my solution
    public String decodeString(String s) {
        int closeBracketIndex = s.indexOf(']');
        int openBracketIndex = s.lastIndexOf('[', closeBracketIndex);
        if (closeBracketIndex < 0) return s;

        int i = 1;
        StringBuilder num = new StringBuilder();
        while (openBracketIndex - i >= 0 && Character.isDigit(s.charAt(openBracketIndex - i))) {
            num.insert(0, s.charAt(openBracketIndex - i++));
        }
        int count = Integer.parseInt(num.toString());

        StringBuilder result = new StringBuilder();
        for (int j = 0; j < count; j++) {
            result.append(s, openBracketIndex + 1, closeBracketIndex);
        }

        return decodeString(s.substring(0, openBracketIndex - num.length()) + result + s.substring(closeBracketIndex + 1));
    }
}
