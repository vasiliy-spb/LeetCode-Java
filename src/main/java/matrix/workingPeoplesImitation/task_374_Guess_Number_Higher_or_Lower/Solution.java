package matrix.workingPeoplesImitation.task_374_Guess_Number_Higher_or_Lower;

public class Solution {

    // my solution
    public static int guessNumber(int n) {
        int down = 0;
        int p = n / 2;
        while (guess(p) != 0) {
            if (guess(p) > 0) down = p + 1;
            else n = p;
            p = (n - down) / 2 + down;
        }
        return p;
    }

    // helper
    public static int guess(int num) {
        int x = 1;
        return x - num;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }

    // from leetcode solutions

    public int guessNumber2(int n) {


        long start = 1, end = n, mid;
        while (start <= end) {

            mid = (start + end) / 2;

            if (guess((int) mid) == 0) return (int) mid;
            else if (guess((int) mid) == 1) start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }

    // from walkccc.me
    public int guessNumber3(int n) {
        int l = 1;
        int r = n;

        // Find the first guess number that >= the target number
        while (l < r) {
            final int m = l + (r - l) / 2;
            if (guess(m) <= 0) // -1, 0
                r = m;
            else
                l = m + 1;
        }

        return l;
    }

}
