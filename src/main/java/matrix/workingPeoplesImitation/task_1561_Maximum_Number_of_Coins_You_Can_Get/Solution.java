package matrix.workingPeoplesImitation.task_1561_Maximum_Number_of_Coins_You_Can_Get;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {

    // my solution
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length / 3;
        int i = 1;
        int count = 0;
        while (n > 0) {
            count += piles[piles.length - 1 - i];
            i += 2;
            n--;
        }
        return count;
    }

    // from leetcode editorial (Approach 1: Greedy Simulation With Deque)
    public int maxCoins2(int[] piles) {
        Arrays.sort(piles);
        ArrayDeque<Integer> queue = new ArrayDeque();
        for (int num : piles) {
            queue.addLast(num);
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            queue.removeLast(); // alice
            ans += queue.removeLast(); // us
            queue.removeFirst(); // bob
        }

        return ans;
    }

    // from leetcode editorial (Approach 2: No Queue)
    public int maxCoins3(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;

        for (int i = piles.length / 3; i < piles.length; i += 2) {
            ans += piles[i];
        }

        return ans;
    }

}
