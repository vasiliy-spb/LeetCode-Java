package matrix.workingPeoplesImitation.task_1894_Find_the_Student_that_Will_Replace_the_Chalk;

// my solution
public class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + chalk[i];
        }
        k %= prefixSum[n];
        return searchIndex(prefixSum, k) - 1;
    }

    private int searchIndex(long[] prefixSum, int k) {
        int left = 0;
        int right = prefixSum.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (prefixSum[middle] > k) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}
