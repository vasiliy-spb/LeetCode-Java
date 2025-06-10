package matrix.workingPeoplesImitation.task_3442_Maximum_Difference_Between_Even_and_Odd_Frequency_I;

import java.util.HashMap;
import java.util.Map;

// my solution
public class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char ch : s.toCharArray()) {
            frequencies.merge(ch, 1, Integer::sum);
        }
        int minEven = Integer.MAX_VALUE;
        int maxEven = Integer.MIN_VALUE;
        int minOdd = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;
        for (int count : frequencies.values()) {
            if (count % 2 == 0) {
                minEven = Math.min(minEven, count);
                maxEven = Math.max(maxEven, count);
            } else {
                minOdd = Math.min(minOdd, count);
                maxOdd = Math.max(maxOdd, count);
            }
        }
        return maxOdd - minEven;
    }
}
