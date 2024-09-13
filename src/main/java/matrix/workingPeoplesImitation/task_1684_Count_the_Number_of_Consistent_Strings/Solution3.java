package matrix.workingPeoplesImitation.task_1684_Count_the_Number_of_Consistent_Strings;

import java.util.Arrays;

// from walkccc.me
public class Solution3 {
    public int countConsistentStrings(String allowed, String[] words) {
        return (int) Arrays.stream(words)
                .filter(word -> word.matches(String.format("[%s]*", allowed)))
                .count();
    }
}
