package matrix.workingPeoplesImitation.task_1137_N_th_Tribonacci_Number;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // my solution
    public int tribonacci(int n) {
        int[] dp = new int[Math.max(n + 1,3)];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    // my solution
    public int tribonacci0(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 0);
        cache.put(1, 1);
        cache.put(2, 1);
        if (n == 0) return 0;
        if (n < 3) return 1;
        return calculateTribonacci(n, cache);
    }

    public int calculateTribonacci(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) return cache.get(n);
        int answer = calculateTribonacci(n - 1, cache) + calculateTribonacci(n - 2, cache) + calculateTribonacci(n - 3, cache);
        cache.put(n, answer);
        return answer;
    }

    // from leetcode solutions
    public int tribonacci2(int n) {
        if (n < 2) return n;
        int a = 0, b = 1, c = 1, d;
        while (n-- > 2) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }

    // from leetcode solutions
    public int tribonacci3(int n) {
        int dp[] = {0, 1, 1};
        for (int i = 3; i <= n; ++i)
            dp[i % 3] = dp[0] + dp[1] + dp[2];
        return dp[n % 3];
    }

    // from leetcode solutions
    public int tribonacci4(int n) {
        int [] trib = new int[n + 3];
        trib [0] = 0;
        trib [1] =  trib [2] = 1;

        for(int i = 3; i <= n; i++){

            trib [i] =   trib [i - 1] + trib [i - 2] + trib [i - 3] ;

        }
        return trib[n];
    }

}
