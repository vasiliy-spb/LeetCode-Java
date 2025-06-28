package matrix.workingPeoplesImitation.task_2220_Minimum_Bit_Flips_to_Convert_Number;

// from walkccc.me
public class Solution2 {
    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }
}
