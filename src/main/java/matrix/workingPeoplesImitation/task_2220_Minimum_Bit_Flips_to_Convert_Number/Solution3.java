package matrix.workingPeoplesImitation.task_2220_Minimum_Bit_Flips_to_Convert_Number;

// from leetcode editorial (Approach 1: Brute Force)
public class Solution3 {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        while (start > 0 || goal > 0) {
            // Increment count if the current bits differ
            if ((start & 1) != (goal & 1)) {
                count++;
            }
            // Shift both numbers to the right to check the next bits
            start >>= 1;
            goal >>= 1;
        }
        return count;
    }
}
