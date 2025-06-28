package matrix.workingPeoplesImitation.task_1415_The_k_th_Lexicographical_String_of_All_Happy_Strings_of_Length_n;

import java.util.Optional;
import java.util.TreeSet;

// my solution
public class Solution {
    public String getHappyString(int n, int k) {
        TreeSet<String> set = new TreeSet<>();
        fillSet(new StringBuilder(), n, set);
        Optional<String> ans = set.stream().skip(k - 1).findFirst();
        return ans.orElse("");
    }

    private static final char[] chars = {'a', 'b', 'c'};

    private void fillSet(StringBuilder current, int n, TreeSet<String> set) {
        if (current.length() == n) {
            set.add(current.toString());
            return;
        }
        char last = '\0';
        if (!current.isEmpty()) {
            last = current.charAt(current.length() - 1);
        }
        for (char ch : chars) {
            if (ch == last) {
                continue;
            }
            fillSet(new StringBuilder().append(current).append(ch), n, set);
        }
    }
}
