package matrix.workingPeoplesImitation.task_3507_Minimum_Pair_Removal_to_Sort_Array_I;

// my solution 2
public class Solution2 {
    public int minimumPairRemoval(int[] nums) {
        int count = 0;
        while (!isSorted(nums)) {
            mergeMinSum(nums);
            count++;
        }
        return count;
    }

    private void mergeMinSum(int[] nums) {
        int[] indexesMinSum = findIndexMinSum(nums);

        nums[indexesMinSum[0]] += nums[indexesMinSum[1]];
        nums[indexesMinSum[1]] = Integer.MIN_VALUE;
    }

    private int[] findIndexMinSum(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        int[] ans = {-1, -1};

        int right = nums.length - 1;
        while (nums[right] == Integer.MIN_VALUE) {
            right--;
        }
        int left = right - 1;
        while (nums[left] == Integer.MIN_VALUE) {
            left--;
        }
        while (left >= 0) {
            int currentSum = nums[right] + nums[left];
            if (currentSum <= minSum) {
                minSum = currentSum;
                ans = new int[]{left, right};
            }
            right = left;
            left--;
            while (left >= 0 && nums[left] == Integer.MIN_VALUE) {
                left--;
            }
        }
        return ans;
    }

    private boolean isSorted(int[] nums) {
        int prev = nums[0];
        int index = 0;
        while (prev == Integer.MIN_VALUE) {
            prev = nums[++index];
        }
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE) {
                continue;
            }
            if (nums[i] < prev) {
                return false;
            }
            prev = nums[i];
        }
        return true;
    }
}
