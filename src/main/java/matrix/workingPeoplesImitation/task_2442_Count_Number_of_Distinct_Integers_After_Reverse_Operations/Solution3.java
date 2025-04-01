package matrix.workingPeoplesImitation.task_2442_Count_Number_of_Distinct_Integers_After_Reverse_Operations;

import java.util.BitSet;

// from leetcode code sample (2)
public class Solution3 {
    public int countDistinctIntegers(int[] nums) {
        BitSet s = new BitSet(1000001);

        for (int num : nums) {
            s.set(num);
            s.set(reverse(num));
        }

        return s.cardinality();
    }

    private int reverse(int num) {
        int temp = 0;
        while (num != 0) {
            temp = temp * 10 + num % 10;
            num /= 10;
        }
        return temp;
    }
}
