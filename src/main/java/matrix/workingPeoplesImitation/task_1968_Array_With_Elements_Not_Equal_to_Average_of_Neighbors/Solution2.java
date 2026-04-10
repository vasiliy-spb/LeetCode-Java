package matrix.workingPeoplesImitation.task_1968_Array_With_Elements_Not_Equal_to_Average_of_Neighbors;

import java.util.Arrays;

// my solution
public class Solution2 {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = nums[0];
        boolean addLeft = false;
        for (int index = 1, left = 1, right = n - 1; index < n - 1; ) {
            if (addLeft) {
                ans[index++] = nums[left++];
            } else {
                ans[index++] = nums[right--];
            }
            addLeft = !addLeft;
        }
        return ans;
    }
}
