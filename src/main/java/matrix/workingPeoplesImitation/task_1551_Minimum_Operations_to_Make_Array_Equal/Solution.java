package matrix.workingPeoplesImitation.task_1551_Minimum_Operations_to_Make_Array_Equal;

// my solution
public class Solution {
    public int minOperations(int n) {
        int delta = n % 2 == 0 ? 1 : 0;
        int value = (n / 2) * 2 + 1 - delta;
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            ans += value - ((2 * i) + 1);
        }
        return ans;
    } // 1 3 5 7 9 11
}
