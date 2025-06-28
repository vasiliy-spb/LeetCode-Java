package matrix.workingPeoplesImitation.task_605_Can_Place_Flowers;

public class Solution {

    // my solution
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int countZero = 1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                countZero++;
            } else {
                n -= (countZero - 1) / 2;
                countZero = 0;
            }
            if (i == flowerbed.length - 1) countZero++;
        }
        n -= (countZero - 1) / 2;
        return n <= 0;
    }
}
