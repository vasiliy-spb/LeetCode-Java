package matrix.workingPeoplesImitation.task_693_Binary_Number_with_Alternating_Bits;

// from walkccc.me
public class Solution2 {
    public boolean hasAlternatingBits(int n) {
        //            n = 0b010101
        //       n >> 2 = 0b000101
        // n ^ (n >> 2) = 0b010000 = a
        //        a - 1 = 0b001111
        //  a & (a - 1) = 0
        final int a = n ^ (n >> 2);
        return (a & (a - 1)) == 0;
    }
}

