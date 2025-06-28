package matrix.workingPeoplesImitation.task_2220_Minimum_Bit_Flips_to_Convert_Number;

// my solution
public class Solution {
    public int minBitFlips(int start, int goal) {
        // 0 0 1 0 1 1
        // 0 1 0 0 0 1
        // 0 1 1 0 1 0 ^
        start ^= goal;
        int countNonZeroBits = 0;
        for (int position = 1; position < 33; position++) {
            int mask = 1 << position;
            if ((start & mask) == mask) {
                countNonZeroBits++;
            }
        }
        return countNonZeroBits;
    }
    public int minBitFlips0(int start, int goal) {
        int count = 0;
        for (int position = 1; position < 33; position++) {
            int num = 1 << position;
            boolean s = (num & start) != 0;
            boolean g = (num & goal) != 0;
            count += s ^ g ? 1 : 0;
        }
        return count;
    }
}
