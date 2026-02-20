package matrix.workingPeoplesImitation.task_693_Binary_Number_with_Alternating_Bits;

// from leetcode editorial (Approach #1: Convert to String)
public class Solution3 {
    public boolean hasAlternatingBits(int n) {
        String bits = Integer.toBinaryString(n);
        for (int i = 0; i < bits.length() - 1; i++) {
            if (bits.charAt(i) == bits.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
