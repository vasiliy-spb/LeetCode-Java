package matrix.workingPeoplesImitation.task_2396_Strictly_Palindromic_Number;

// my solution
public class Solution {
    public boolean isStrictlyPalindromic(int n) {
        int num = 2;
        while (num < n) {
            if (n % num != 0) {
                return false;
            }
            num++;
        }
        return true;
    }
}
