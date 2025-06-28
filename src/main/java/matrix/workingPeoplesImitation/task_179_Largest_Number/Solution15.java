package matrix.workingPeoplesImitation.task_179_Largest_Number;

import java.util.Arrays;
import java.util.stream.Collectors;

// from leetcode code sample (7)
public class Solution15 {
    public String largestNumber(int[] nums) {
        final String s = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.joining(""));
        return s.startsWith("00") ? "0" : s;
    }
}
