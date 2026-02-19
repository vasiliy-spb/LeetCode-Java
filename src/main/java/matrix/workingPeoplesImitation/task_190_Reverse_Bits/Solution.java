package matrix.workingPeoplesImitation.task_190_Reverse_Bits;

// my solution
public class Solution {
    public int reverseBits(int n) {
        return Integer.parseInt(new StringBuilder(Integer.toBinaryString(n)).reverse() + "0".repeat(32 - Integer.toBinaryString(n).length()), 2);
    }
}
