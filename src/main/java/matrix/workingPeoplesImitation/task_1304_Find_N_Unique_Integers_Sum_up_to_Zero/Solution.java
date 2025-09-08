package matrix.workingPeoplesImitation.task_1304_Find_N_Unique_Integers_Sum_up_to_Zero;

// my solution
public class Solution {
    public int[] sumZero(int n) {
        int sum = 0;
        int[] ans = new int[n];
        for (int i = 1; i < n; i++) {
            ans[i] = i;
            sum += i;
        }
        ans[0] = -sum;
        return ans;
    }
}
