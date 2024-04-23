package matrix.workingPeoplesImitation.task_189_Rotate_Array;

public class Solution {

    // my solution
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            result[index++] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            result[index++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int prev = nums[i];
            int prevIndex = i;
            int start = nums[i];
            for (int j = i; j < nums.length; j += k) {
                if (nums[(j + k) % nums.length] == start) {
                    nums[j] = start;
                    break;
                }
                prev = nums[j];
                nums[j] = nums[(j + k) % nums.length];
//                nums[prevIndex] = prev;
//                prevIndex = j;
            }
        }
    }

    public void rotate1(int[] nums, int k) {
        int shift = nums.length - k;
        for (int i = 0; i < shift; i++) {
            int prev = nums[i];
            int prevIndex = i;
            for (int j = i; j < nums.length - k; j += shift) {
                prev = nums[j % nums.length];
                nums[j % nums.length] = nums[prevIndex];
                nums[prevIndex] = prev;
                prevIndex = j % nums.length;
            }
        }
    }

    public void rotate0(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int prev = nums[i];
            int prevIndex = i;
            for (int j = i; j < nums.length; j += k) {
                prev = nums[j];
                nums[j] = nums[prevIndex];
                nums[prevIndex] = prev;
                prevIndex = j;
            }
        }
    }

    // from walkccc.me
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r)
            swap(nums, l++, r--);
    }

    private void swap(int[] nums, int l, int r) {
        final int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}

// 0 1 2 3 4 5 6 7 8 9
// 3
// 7 8 9 0 1 2 3 4 5 6
// 4
// 6 7 8 9 0 1 2 3 4 5



