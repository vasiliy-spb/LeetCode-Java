package matrix.workingPeoplesImitation.task_1963_Minimum_Number_of_Swaps_to_Make_the_String_Balanced;

// from walkccc.me
public class Solution4 {
    public int minSwaps(String s) {
        // Cancel out all the matched pairs, then we'll be left with "]]]..[[[".
        // The answer is ceil(the number of unmatched pairs / 2).
        int unmatched = 0;

        for (final char c : s.toCharArray())
            if (c == '[') {
                ++unmatched;
            } else if (unmatched > 0) { // c == ']' and there's a match.
                --unmatched;
            }

        return (unmatched + 1) / 2;
    }
}
