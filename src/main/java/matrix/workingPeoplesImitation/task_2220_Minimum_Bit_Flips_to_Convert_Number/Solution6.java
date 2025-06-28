package matrix.workingPeoplesImitation.task_2220_Minimum_Bit_Flips_to_Convert_Number;

// from leetcode editorial (Approach 4: Brian Kernighan’s Algorithm)
public class Solution6 {
    public int minBitFlips(int start, int goal) {
        // XOR to find differing bits
        int xorResult = start ^ goal;
        int count = 0;
        // Brian Kernighans algorithm to count 1s
        while (xorResult != 0) {
            xorResult &= (xorResult - 1); // Clear the lowest set bit
            count++;
        }
        return count;
    }
}
