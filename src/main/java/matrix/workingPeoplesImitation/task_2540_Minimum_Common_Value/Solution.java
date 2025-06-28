package matrix.workingPeoplesImitation.task_2540_Minimum_Common_Value;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    // my solution (two pointers approach)
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) return nums1[i];
            if (nums1[i] > nums2[j]) j++;
            else i++;
        }
        return -1;
    }

    // my solution (hashSet approach)
    public int getCommon1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1)
            set.add(i);
        for (int j : nums2)
            if (set.contains(j)) return j;
        return -1;
    }

    // from leetcode editorial (binary search approach)
    public int getCommon3(int[] nums1, int[] nums2) {
        // Binary search should be done on the larger array
        // If nums1 is longer, call getCommon with the arrays swapped
        if (nums1.length > nums2.length) {
            return getCommon3(nums2, nums1);
        }

        // Search for each element of nums1 in nums2
        // Return the first common element found
        for (int num : nums1) {
            if (binarySearch(num, nums2)) {
                return num;
            }
        }

        // Return -1 if there are no common elements
        return -1;
    }

    private boolean binarySearch(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
