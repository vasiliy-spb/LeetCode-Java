package matrix.workingPeoplesImitation.task_2022_Convert_1D_Array_Into_2D_Array;

// from walkccc.me (like in leetcode editorial (Approach 2: Math))
public class Solution2 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n)
            return new int[][] {};

        int[][] ans = new int[m][n];

        for (int i = 0; i < original.length; ++i)
            ans[i / n][i % n] = original[i];

        return ans;
    }
}
