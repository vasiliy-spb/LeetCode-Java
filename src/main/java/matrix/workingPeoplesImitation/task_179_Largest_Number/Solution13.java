package matrix.workingPeoplesImitation.task_179_Largest_Number;

import java.util.Arrays;
import java.util.Comparator;

// from leetcode code sample (5)
public class Solution13 {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comparator = (one, two) -> (one + two).compareTo(two + one);

        Arrays.sort(strings, comparator.reversed());

        StringBuilder stringBuilder = new StringBuilder();

        for (String s : strings) {
            stringBuilder.append(s);
        }

        String result = stringBuilder.toString();

        while (result.length() > 1 && result.charAt(0) == '0') {
            result = result.substring(1);
        }

        return result;
    }
}
