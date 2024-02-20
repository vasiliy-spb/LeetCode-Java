package matrix.workingPeoplesImitation.task_231_Power_of_Two;

public class Solution {

    // my solution
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        return (n & (n - 1)) == 0;
    }

    // from leetcode solutions
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & n - 1) == 0;
    }

}
