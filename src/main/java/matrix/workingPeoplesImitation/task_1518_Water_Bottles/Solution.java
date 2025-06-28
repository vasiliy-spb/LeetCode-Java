package matrix.workingPeoplesImitation.task_1518_Water_Bottles;

public class Solution {

    // my solution
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        int add = 0;
        while (numBottles > 0) {
            int newAdd = (numBottles + add) % numExchange;
            numBottles = (numBottles + add) / numExchange;
            add = newAdd;
            count += numBottles;
        }
        return count;
    }

    // from leetcode editorial (Approach 1: Simulation)
    public int numWaterBottles2(int numBottles, int numExchange) {
        int consumedBottles = 0;

        while (numBottles >= numExchange) {
            // Consume numExchange full bottles.
            consumedBottles += numExchange;
            numBottles -= numExchange;

            // Exchange them for one full bottle.
            numBottles++;
        }

        // Consume the remaining numBottles (<numExchange).
        return consumedBottles + numBottles;
    }

    // from leetcode editorial (Approach 2: Optimized Simulation)
    public int numWaterBottles3(int numBottles, int numExchange) {
        int consumedBottles = 0;

        while (numBottles >= numExchange) {
            // Maximum number of times we can consume numExchange
            // number of bottles using numBottles.
            int K = numBottles / numExchange;

            consumedBottles += numExchange * K;
            numBottles -= numExchange * K;

            numBottles += K;
        }

        return consumedBottles + numBottles;
    }

    // from walkccc.me (Approach 1: O(log numBottles) space)
    public int numWaterBottles4(int numBottles, int numExchange) {
        int ans = numBottles;

        while (numBottles >= numExchange) {
            ans += numBottles / numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }

        return ans;
    }

    // from walkccc.me (Approach 2: O(1) space)
    public int numWaterBottles5(int numBottles, int numExchange) {
        return numBottles + (numBottles - 1) / (numExchange - 1);
    }

}
