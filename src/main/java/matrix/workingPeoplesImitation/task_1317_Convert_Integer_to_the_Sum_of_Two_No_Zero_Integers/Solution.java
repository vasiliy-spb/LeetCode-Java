package matrix.workingPeoplesImitation.task_1317_Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers;

// my solution
public class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; i++) {
            if (!hasZero(i) && !hasZero(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return new int[]{};
    }

    private boolean hasZero(int n) {
        return String.valueOf(n).indexOf('0') >= 0;
    }
}
