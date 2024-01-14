package matrix.workingPeoplesImitation.task_303_Range_Sum_Query_Immutable;

public class NumArray {
    private int[] nums;
    private int[] prefixSum;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.prefixSum = calculatePrefixSum(nums);
    }

    private int[] calculatePrefixSum(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        return prefixSum;
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
