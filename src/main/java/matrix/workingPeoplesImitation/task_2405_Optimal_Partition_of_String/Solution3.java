package matrix.workingPeoplesImitation.task_2405_Optimal_Partition_of_String;

// from leetcode code sample (1)
public class Solution3 {

    // Method 4 : Using bit masking and shifting, getBytes(), byte[]  to track repeating letter before partioning
    public int partitionString(String s) {
        int count = 1;
        int bitMask = 0;
        byte[] charss = new byte[s.length()];
        s.getBytes(0, s.length(), charss, 0);

        for (byte currentChar : charss) {
            int currentBit = 1 << currentChar;
            if ((currentBit & bitMask) != 0) {
                count++;
                bitMask = currentBit;
            } else {
                bitMask = currentBit | bitMask;
            }
        }
        return count;
    }
}
