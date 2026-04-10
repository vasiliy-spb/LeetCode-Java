package matrix.workingPeoplesImitation.task_2048_Next_Greater_Numerically_Balanced_Number;

// from walkccc.me
public class Solution4 {
    public int nextBeautifulNumber(int n) {
        while (!isBalance(++n))
            ;
        return n;
    }

    private boolean isBalance(int num) {
        int[] count = new int[10];
        while (num > 0) {
            if (num % 10 == 0)
                return false;
            ++count[num % 10];
            num /= 10;
        }
        for (int i = 1; i < 10; ++i)
            if (count[i] > 0 && count[i] != i)
                return false;
        return true;
    }
}
