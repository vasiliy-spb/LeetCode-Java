package matrix.workingPeoplesImitation.task_693_Binary_Number_with_Alternating_Bits;

// from leetcode editorial (Approach #2: Divide By Two)
public class Solution4 {
    public boolean hasAlternatingBits(int n) {
        int cur = n % 2;
        n /= 2;
        while (n > 0) {
            if (cur == n % 2) return false;
            cur = n % 2;
            n /= 2;
        }
        return true;
    }
}
