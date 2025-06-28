package matrix.workingPeoplesImitation.task_1780_Check_if_Number_is_a_Sum_of_Powers_of_Three;

import java.util.HashSet;
import java.util.Set;

// my solution
public class Solution {
    public boolean checkPowersOfThree(int n) {
        int pow = 0;
        int x = (int) Math.pow(3, pow);
        Set<Integer> set = new HashSet<>();
        while (n > 0) {
            while (x <= n) {
                pow++;
                x = (int) Math.pow(3, pow);
            }
            if (pow > 0) {
                pow--;
            }
            while (set.contains(pow)) {
                if (pow == 0) {
                    return false;
                }
                pow--;
            }
            set.add(pow);
            n -= (int)  Math.pow(3, pow);
            pow = 0;
            x = (int) Math.pow(3, pow);
        }
        return true;
    }
}
