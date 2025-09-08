package matrix.workingPeoplesImitation.task_1304_Find_N_Unique_Integers_Sum_up_to_Zero;

// from walkccc.me
public class Solution3 {
    public int[] sumZero(int n) {
        int[] ans = new int[n];

        for (int i = 0; i < n; ++i)
            ans[i] = i * 2 - n + 1;

        return ans;
    }
}
