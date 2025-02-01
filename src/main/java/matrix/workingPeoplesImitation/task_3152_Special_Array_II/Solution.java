package matrix.workingPeoplesImitation.task_3152_Special_Array_II;

// my solution
public class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int n = queries.length;
        int[] ansArray = prepareAnsArray(nums);
        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            int fromIndex = query[0];
            int toIndex = query[1];
            ans[i] = ansArray[toIndex + 1] >= toIndex - fromIndex + 1;
        }
        return ans;
    }

    private int[] prepareAnsArray(int[] nums) {
        int n = nums.length;
        int[] preparedArray = new int[n + 1];
        preparedArray[1] = 1;
        for (int i = 1; i < n; i++) {
            preparedArray[i + 1] = 1;
            if (((nums[i] % 2) ^ (nums[i - 1] % 2)) == 1) {
                preparedArray[i + 1] += preparedArray[i];
            }
        }
        return preparedArray;
    }
}
