package matrix.workingPeoplesImitation.task_2220_Minimum_Bit_Flips_to_Convert_Number;

// from leetcode editorial (Approach 2: Recursive Approach)
public class Solution4 {
    public int minBitFlips(int start, int goal) {
        // Base case: both numbers have been fully processed
        if (start == 0 && goal == 0) return 0;

        // Flip for the current least significant bit
        int flip = (start & 1) != (goal & 1) ? 1 : 0;

        // Recurse for the next bits by right-shifting both numbers
        return flip + minBitFlips(start >> 1, goal >> 1);
    }
}
