package matrix.workingPeoplesImitation.task_2165_Smallest_Value_of_Rearranged_Number;

import java.util.stream.Collectors;
import java.util.stream.Stream;

// from walkccc.me
public class Solution2 {
    public long smallestNumber(long num) {
        String[] digits = String.valueOf(Math.abs(num)).split("");
        String s = Stream.of(digits).sorted().collect(Collectors.joining());
        StringBuilder sb = new StringBuilder(s);
        if (num <= 0)
            return -1 * Long.parseLong(sb.reverse().toString());
        if (sb.charAt(0) == '0') {
            final int firstNonZeroIndex = sb.lastIndexOf("0") + 1;
            sb.setCharAt(0, sb.charAt(firstNonZeroIndex));
            sb.setCharAt(firstNonZeroIndex, '0');
        }
        return Long.parseLong(sb.toString());
    }
}
