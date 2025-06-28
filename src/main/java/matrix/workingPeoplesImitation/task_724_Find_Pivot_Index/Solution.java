package matrix.workingPeoplesImitation.task_724_Find_Pivot_Index;

public class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (prefixSum[i] == (prefixSum[nums.length] - prefixSum[i] - nums[i])) return i;
        }
        return -1;
    }
}
