package matrix.workingPeoplesImitation.task_2134_Minimum_Swaps_to_Group_All_1_s_Together_II;

// my solution
public class Solution {
    public int minSwaps(int[] nums) {
        int countOnes = 0;
        for (int num : nums) {
            countOnes += num;
        }
        int left = 0;
        int right = 0;
        int currentSum = 0;
        while (right < countOnes) {
            currentSum += nums[right++];
        }
        int maxSum = currentSum;
        while (left < nums.length) {
            right %= nums.length;
            currentSum -= nums[left++];
            currentSum += nums[right++];
            maxSum = Math.max(maxSum, currentSum);
        }
        return countOnes - maxSum;
    }
}
