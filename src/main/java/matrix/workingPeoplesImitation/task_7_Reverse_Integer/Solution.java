package matrix.workingPeoplesImitation.task_7_Reverse_Integer;

public class Solution {

    // my solution
    public int reverse(int x) {
        long ans = 0;
        int sign = x > 0 ? 1 : -1;
        x = Math.abs(x);
        while (x > 0) {
            ans *= 10;
            ans += x % 10;
            x /= 10;
        }
        if (ans > Integer.MAX_VALUE || -ans < Integer.MIN_VALUE) return 0;
        return (int) ans * sign;
    }

    // from walkccc.me
    public int reverse1(int x) {
        long ans = 0;

        while (x != 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }

        return (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) ? 0 : (int) ans;
    }

    // from leetcode solutions
    public int reverse2(int x) {
        int prevRev = 0 , rev= 0;
        while( x != 0){
            rev= rev*10 + x % 10;
            if((rev - x % 10) / 10 != prevRev){
                return 0;
            }
            prevRev = rev;
            x= x/10;
        }
        return rev;
    }

}
