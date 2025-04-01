package matrix.workingPeoplesImitation.task_2442_Count_Number_of_Distinct_Integers_After_Reverse_Operations;

import java.util.HashSet;
import java.util.Set;

// my solution
public class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> distinctNum = new HashSet<>();
        for (int num : nums) {
            distinctNum.add(num);
            distinctNum.add(reverseDigits(num));
        }
        return distinctNum.size();
    }

    private int reverseDigits(int num) {
        int result = 0;
        while (num > 0) {
            result *= 10;
            result += num % 10;
            num /= 10;
        }
        return result;
    }
}
