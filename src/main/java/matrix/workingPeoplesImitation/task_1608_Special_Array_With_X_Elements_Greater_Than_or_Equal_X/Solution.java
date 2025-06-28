package matrix.workingPeoplesImitation.task_1608_Special_Array_With_X_Elements_Greater_Than_or_Equal_X;

import java.util.Arrays;

public class Solution {

    // my solution
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1];
        while (left < right) {
            int middle = (left + right) / 2;
            int position = binarySearchPosition(nums, middle);
            if (position == nums.length - middle) return middle;
            if (position > nums.length - middle) right = middle;
            else left = middle + 1;
        }
        return nums[0] == nums[nums.length - 1] && nums[0] == nums.length ? nums.length : -1;
    }
    private int binarySearchPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] < target) left = middle + 1;
            else right = middle;
        }
        return left;
    }

    // from editorial (Approach 1: Sorting)
    private int getFirstGreaterOrEqual(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;

        int index = nums.length;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] >= val) {
                index = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return index;
    }

    public int specialArray2(int[] nums) {
        Arrays.sort(nums);

        int N = nums.length;
        for (int i = 1; i <= N; i++) {
            int k = getFirstGreaterOrEqual(nums, i);

            if (N - k == i) {
                return i;
            }
        }

        return -1;
    }

    // from editorial (Approach 2: Counting Sort + Prefix Sum)
    public int specialArray3(int[] nums) {
        int N = nums.length;
        int[] freq = new int[N + 1];

        for (int i = 0; i < N; i++) {
            freq[Math.min(N, nums[i])]++;
        }

        int numGreaterThanOrEqual = 0;
        for (int i = N; i >= 1; i--) {
            numGreaterThanOrEqual += freq[i];
            if (i == numGreaterThanOrEqual) {
                return i;
            }
        }

        return -1;
    }

    // from walkccc.me
    public int specialArray4(int[] nums) {
        Arrays.sort(nums);

        if (nums[0] >= nums.length)
            return nums.length;

        for (int i = 1; i < nums.length; ++i) {
            final int count = nums.length - i;
            if (nums[i - 1] < count && nums[i] >= count)
                return count;
        }

        return -1;
    }

}
