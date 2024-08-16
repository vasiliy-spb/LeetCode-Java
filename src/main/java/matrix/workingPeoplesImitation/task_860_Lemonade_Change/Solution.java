package matrix.workingPeoplesImitation.task_860_Lemonade_Change;

public class Solution {

    // my solution
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        for (int b : bills) {
            if (b == 5) {
                count5++;
            }
            if (b == 10) {
                if (count5 > 0) {
                    count10++;
                    count5--;
                } else {
                    return false;
                }
            }
            if (b == 20) {
                if (count5 <= 0) {
                    return false;
                }
                if (count10 > 0) {
                    count10--;
                    count5--;
                } else {
                    count5 -= 3;
                }
                if (count5 < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
