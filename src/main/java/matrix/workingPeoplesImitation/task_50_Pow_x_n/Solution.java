package matrix.workingPeoplesImitation.task_50_Pow_x_n;

public class Solution {

    // my solution (WA)
    public double myPow(double x, int n) {
        if (x == 1) return x;
        if (x == -1) return n % 2 == 0 ? 1 : -1;
        boolean negative = n < 0;
        n = negative ? -n : n;
        double ans = 1;
        while (n-- > 0)
            ans *= x;
        return negative ? 1 / ans : ans;
    }

    // my solution
    public double myPow1(double x, int n) {
        return Math.pow(x, n);
    }

    // from walkccc.me
    public double myPow2(double x, long n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 1 / myPow2(x, -n);
        if (n % 2 == 1)
            return x * myPow2(x, n - 1);
        return myPow2(x * x, n / 2);
    }
}
