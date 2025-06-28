package matrix.workingPeoplesImitation.task_1833_Maximum_Ice_Cream_Bars;

// my solution
public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int cost : costs) {
            min = Math.min(min, cost);
            max = Math.max(max, cost);
        }
        int[] countArray = new int[max - min + 1];
        for (int cost : costs) {
            countArray[cost - min]++;
        }
        int countIceCream = 0;
        for (int i = 0; i < countArray.length; i++) {
            int count = countArray[i];
            if (count == 0) {
                continue;
            }
            if (coins >= (i + min) * count) {
                coins -= (i + min) * count;
                countIceCream += count;
            } else {
                while (coins >= i + min && count-- > 0) {
                    countIceCream++;
                    coins -= i + min;
                }
            }
        }
        return countIceCream;
    }
}
