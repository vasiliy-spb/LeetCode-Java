package matrix.workingPeoplesImitation.task_1910_Remove_All_Occurrences_of_a_Substring;

// my solution (05.11.2024)
public class Solution {
    public String removeOccurrences(String s, String part) {
        while (s.indexOf(part) >= 0) {
            s = s.replaceFirst(part, "");
        }
        return s;
    }
}
