package matrix.workingPeoplesImitation.task_1894_Find_the_Student_that_Will_Replace_the_Chalk;

// from leetcode editorial (Approach 1: Prefix Sum)
public class Solution2 {
    public int chalkReplacer(int[] chalk, int k) {
        // Find the sum of all elements.
        long sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
            if (sum > k) {
                break;
            }
        }
        // Find modulo of k with sum.
        k = k % (int) sum;
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k = k - chalk[i];
        }
        return 0;
    }
}
