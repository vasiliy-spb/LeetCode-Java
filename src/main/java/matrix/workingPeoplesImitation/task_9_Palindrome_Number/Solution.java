package matrix.workingPeoplesImitation.task_9_Palindrome_Number;

public class Solution {

    // my solution
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        return x == Long.parseLong(new StringBuilder(Math.abs(x) + "").reverse().toString());
    }

    // from walkccc.me
    public boolean isPalindrome2(int x) {
        if (x < 0)
            return false;

        long reversed = 0;
        int y = x;

        while (y > 0) {
            reversed = reversed * 10 + y % 10;
            y /= 10;
        }

        return reversed == x;
    }


}
