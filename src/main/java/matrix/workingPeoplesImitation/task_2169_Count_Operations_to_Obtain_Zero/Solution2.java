package matrix.workingPeoplesImitation.task_2169_Count_Operations_to_Obtain_Zero;

// from leetcode editorial (Approach: Euclidean Algorithm)
public class Solution2 {
    public int countOperations(int num1, int num2) {
        int res = 0; // total number of subtraction operations
        while (num1 != 0 && num2 != 0) {
            // each step of the Euclidean algorithm
            res += num1 / num2;
            num1 %= num2;
            // swap two numbers
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        return res;
    }
}
