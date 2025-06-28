package matrix.workingPeoplesImitation.task_485_Max_Consecutive_Ones;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnesCount = 0;
        int currentCount = 0;
        for (int i : nums)
            if (i == 1)
                maxOnesCount = Math.max(maxOnesCount, ++currentCount);
            else
                currentCount = 0;
        return maxOnesCount;
    }
}
