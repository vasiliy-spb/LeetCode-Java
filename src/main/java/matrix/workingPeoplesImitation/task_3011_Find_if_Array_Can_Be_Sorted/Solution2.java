package matrix.workingPeoplesImitation.task_3011_Find_if_Array_Can_Be_Sorted;

// from walkccc.me
public class Solution2 {
    public boolean canSortArray(int[] nums) {
        // Divide the array into distinct segments where each segment is comprised
        // of consecutive elements sharing an equal number of set bits. Ensure that
        // for each segment, when moving from left to right, the maximum of a
        // preceding segment is less than the minimum of the following segment.
        int prevSetBits = 0;
        int prevMax = Integer.MIN_VALUE; // the maximum of the previous segment
        int currMax = Integer.MIN_VALUE; // the maximum of the current segment
        int currMin = Integer.MAX_VALUE; // the minimum of the current segment

        for (final int num : nums) {
            final int setBits = Integer.bitCount(num);
            if (setBits != prevSetBits) { // Start a new segment.
                if (prevMax > currMin)
                    return false;
                prevSetBits = setBits;
                prevMax = currMax;
                currMax = num;
                currMin = num;
            } else { // Continue with the current segment.
                currMax = Math.max(currMax, num);
                currMin = Math.min(currMin, num);
            }
        }

        return prevMax <= currMin;
    }
}
