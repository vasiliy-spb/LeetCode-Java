package matrix.workingPeoplesImitation.task_1551_Minimum_Operations_to_Make_Array_Equal;

// from leetcode code sample (2)
public class Solution4 {
    public static int minOperations(int n) {
        int operations = 0;

        for (int i = 0; i < n / 2; i++) {
            operations += n - ((2 * i) + 1);
        }

        return operations;
    }
}
