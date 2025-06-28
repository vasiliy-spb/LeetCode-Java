package matrix.workingPeoplesImitation.task_790_Domino_and_Tromino_Tiling;

import java.util.Arrays;

public class Solution {

    // my solution (after tip from leetcode Discussion)
    public int numTilings(int n) {
        int modulo = (int) 1e9 + 7;
        long dp[] = new long[Math.max(n + 1, 4)];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % modulo;
        }
        return (int) dp[n];
    }

    public int numTilings1(int n) {
        int modulo = (int) 1e9 + 7;
        int dp[] = new int[Math.max(n + 1, 4)];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5; // 1 * 2
//        dp[4] = 11; // 3 * 2
//        dp[5] = 24; // 8 * 2
//        dp[6] = 53;
//        dp[7] = 117;
        for (int i = 4; i <= n; i++) {
//            dp[i] = dp[3] * (i / 3) + (i % 3) * i + dp[2] * (i / 2) + (i % 2) * i;

//            dp[i] = fibonacci[i] + (fibonacci[i + 2]);


//            dp[i] = dp[i - 1] + (i) + dp[i - 2] + (i - 2) * 2;
//            dp[i] = dp[4] * (i / 4) + dp[3] * (i / 3) + dp[2] * (i / 2) + i;
//            dp[i] = (dp[3] * ((i * 2) / 3)) + (dp[2] * ((i * 2) / 2)) + i;


//            int size = i * 2;
//            int tromino = (size / 6) * dp[4];
//            size = size % 4;
//
//
////            int tromino = ((i * 2) / 6) * 2;
//            dp[i] = dp[i - 1] + tromino * ( i + ((i * 2) % 6) );
        }
        return dp[n];
    }
}
