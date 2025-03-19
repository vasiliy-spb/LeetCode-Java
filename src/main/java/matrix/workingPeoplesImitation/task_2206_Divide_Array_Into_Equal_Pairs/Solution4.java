package matrix.workingPeoplesImitation.task_2206_Divide_Array_Into_Equal_Pairs;

// from leetcode editorial (Approach 3: Boolean Array)
public class Solution4 {
    public boolean divideArray(int[] nums) {
        // Find maximum value in array
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
        }

        // Toggle pair status for each number
        boolean[] needsPair = new boolean[maxNum + 1];
        for (int num : nums) {
            needsPair[num] = !needsPair[num];
        }

        // Check if any number remains unpaired
        for (int num : nums) {
            if (needsPair[num]) {
                return false;
            }
        }

        return true;
    }
}
