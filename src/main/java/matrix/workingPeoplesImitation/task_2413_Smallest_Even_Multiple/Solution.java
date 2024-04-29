package matrix.workingPeoplesImitation.task_2413_Smallest_Even_Multiple;

public class Solution {

    // my solution
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }

    // from walkccc.me
    public int smallestEvenMultiple2(int n) {
        return n * (n % 2 + 1);
    }
}
