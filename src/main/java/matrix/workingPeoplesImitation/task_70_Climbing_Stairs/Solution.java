package matrix.workingPeoplesImitation.task_70_Climbing_Stairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // my solution
    public int climbStairs1(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // my solution
    public int climbStairs(int n) {
        if (n < 3) return n;
        int[] cache = new int[n + 1];
        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }
}
