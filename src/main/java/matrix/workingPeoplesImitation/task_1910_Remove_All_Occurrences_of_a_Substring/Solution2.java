package matrix.workingPeoplesImitation.task_1910_Remove_All_Occurrences_of_a_Substring;

// my solution (11.02.2025)
public class Solution2 {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(ch);
            if (sb.length() >= part.length() && sb.substring(sb.length() - part.length()).equals(part)) {
                sb.setLength(sb.length() - part.length());
            }
        }
        return sb.toString();
    }
}
