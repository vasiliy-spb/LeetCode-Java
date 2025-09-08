package matrix.workingPeoplesImitation.task_1317_Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers;

// from leetcode editorial
public class Solution2 {
    public int[] getNoZeroIntegers(int n) {
        for (int A = 1; A < n; ++A) {
            int B = n - A;
            if (!String.valueOf(A).contains("0") &&
                !String.valueOf(B).contains("0")) {
                return new int[]{A, B};
            }
        }
        return new int[0];
    }
}
