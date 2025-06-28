package matrix.workingPeoplesImitation.task_75_Sort_Colors;

public class Solution {

    // my solution
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                int temp = nums[left];
                nums[left++] = nums[i];
                nums[i] = temp;
            } else if (nums[i] == 2) {
                int temp = nums[right];
                nums[right--] = nums[i];
                nums[i--] = temp;
            }
        }
    }

    // from walkccc.me (Approach 1: 3 pointers)
    public void sortColors2(int[] nums) {
        int zero = -1;
        int one = -1;
        int two = -1;

        for (final int num : nums)
            if (num == 0) {
                nums[++two] = 2;
                nums[++one] = 1;
                nums[++zero] = 0;
            } else if (num == 1) {
                nums[++two] = 2;
                nums[++one] = 1;
            } else {
                nums[++two] = 2;
            }
    }

    // from walkccc.me (Approach 2: 2 pointers + swapping)
    public void sortColors3(int[] nums) {
        int l = 0;               // The next 0 should be placed in l.
        int r = nums.length - 1; // THe next 2 should be placed in r.

        for (int i = 0; i <= r;)
            if (nums[i] == 0)
                swap(nums, i++, l++);
            else if (nums[i] == 1)
                ++i;
            else
                // We may swap a 0 to index i, but we're still not sure whether this 0
                // is placed in the correct index, so we can't move pointer i.
                swap(nums, i, r--);
    }

    private void swap(int[] nums, int i, int j) {
        final int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

