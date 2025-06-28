package matrix.workingPeoplesImitation.task_62_Unique_Paths;

import java.util.Arrays;

public class Solution {

    // my solution
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] += dp[i - 1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }

    // from walkccc.me (Approach 1: 2D DP)
    public int uniquePaths2(int m, int n) {
        // dp[i][j] := the number of unique paths from (0, 0) to (i, j)
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(A -> Arrays.fill(A, 1));

        for (int i = 1; i < m; ++i)
            for (int j = 1; j < n; ++j)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        return dp[m - 1][n - 1];
    }

    // from walkccc.me (Approach 2: 1D DP)
    public int uniquePaths3(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; ++i)
            for (int j = 1; j < n; ++j)
                dp[j] += dp[j - 1];

        return dp[n - 1];
    }

    // from leetcode solutions
    //
    // This is a combinatorial problem and can be solved without DP. For mxn grid, robot has to move exactly m-1 steps down and n-1 steps right and these can be done in any order.
    // For the eg., given in question, 3x7 matrix, robot needs to take 2+6 = 8 steps with 2 down and 6 right in any order. That is nothing but a permutation problem. Denote down as 'D' and right as 'R', following is one of the path :-
    // D R R R D R R R
    // We have to tell the total number of permutations of the above given word. So, decrease both m & n by 1 and apply following formula:-
    // Total permutations = (m+n)! / (m! * n!)
    public int uniquePaths4(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if(m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }

        return (int)res;
    }
    // from comments
    //
    // Explanation for (m+n)!/(m! *n!):
    // If the matrix is 3x7, we have 10 grids to reach the finish because 3 + 7 = 10
    // The maximum right (The direction 'right' not right-wrong 'right') moves we can have is 3 since it's a 3x7 matrix.
    // The maximum down moves we can have is 7 since it's a 3x7 matrix.
    // No. of ways in which we can choose the right turn? It's C(10,3) = 10! / (7! * 3!) => (m+n)! / (m!*n!)
    // If you don't know what C(10,3) is, read about combinations here https://betterexplained.com/articles/easy-permutations-and-combinations/

}
