package matrix.workingPeoplesImitation.task_1910_Remove_All_Occurrences_of_a_Substring;

// from walkccc.me
public class Solution5 {
    public String removeOccurrences(String s, String part) {
        final int n = s.length();
        final int k = part.length();

        StringBuilder sb = new StringBuilder(s);
        int j = 0; // sb's index

        for (int i = 0; i < n; ++i) {
            sb.setCharAt(j++, s.charAt(i));
            if (j >= k && sb.substring(j - k, j).equals(part))
                j -= k;
        }

        return sb.substring(0, j);
    }
}
