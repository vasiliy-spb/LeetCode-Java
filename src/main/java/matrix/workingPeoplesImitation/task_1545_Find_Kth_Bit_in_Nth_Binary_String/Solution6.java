package matrix.workingPeoplesImitation.task_1545_Find_Kth_Bit_in_Nth_Binary_String;

// from walkccc.me
public class Solution6 {
    public char findKthBit(int n, int k) {
        if (n == 1)
            return '0';
        final int midIndex = (int) Math.pow(2, n - 1); // 1-indexed
        if (k == midIndex)
            return '1';
        if (k < midIndex)
            return findKthBit(n - 1, k);
        return findKthBit(n - 1, midIndex * 2 - k) == '0' ? '1' : '0';
    }
}
