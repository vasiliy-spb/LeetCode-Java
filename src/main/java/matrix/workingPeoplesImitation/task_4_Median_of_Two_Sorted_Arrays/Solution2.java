package matrix.workingPeoplesImitation.task_4_Median_of_Two_Sorted_Arrays;

public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean even = (nums1.length + nums2.length) % 2 == 0;
        int n = nums1.length + nums2.length;
        int[] arr1 = null;
        int[] arr2 = null;
        if (nums1[nums1.length - 1] <= nums2[0]) {
            arr1 = nums1;
            arr2 = nums2;
        }
        if (nums2[nums2.length - 1] <= nums1[0]) {
            arr1 = nums2;
            arr2 = nums1;
        }
        if (arr1 != null && arr1[arr1.length - 1] <= arr2[0]) {
            int index = even ? n / 2 - 1 : n / 2;
            if (even) {
                if (index + 1 < arr1.length) return (arr1[index] + arr1[index + 1]) / 2d;
                if (index >= arr1.length) {
                    index -= arr1.length - 1;
                    return (arr2[index] + arr2[index + 1]) / 2d;
                }
                return (arr1[index] + arr2[index + 1 - arr1.length]) / 2d;
            } else {
                if (index < arr1.length) return arr1[index];
                else {
                    index -= arr1.length - 1;
                    return arr2[index];
                }
            }
        }
        int index = -1;
        int left = 0;
        int right = nums1.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            int countLess = calculateLessCount(nums2, nums1[middle]);
            countLess = Math.max(countLess, 0);
            if (even && countLess == n - countLess || !even && Math.abs(countLess - (n - countLess)) == 1) {
                index = middle;
                break;
            }
            if (countLess > n - countLess) right = middle;
            else left = middle + 1;
        }
        if (index < 0) {
            int countLess = calculateLessCount(nums2, nums1[left]);
            countLess = Math.max(countLess, 0);
            if (even && countLess == n - countLess || !even && Math.abs(countLess - (n - countLess)) == 1) {
                index = left;
            }
        }
        if (index >= 0) {
            if (!even) return nums1[index];
            int nextNum = calculateLessCount2(nums2, nums1[index]);
            return (nums1[index] + nums2[nextNum]) / 2d;
        }
        left = 0;
        right = nums2.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            int countLess = calculateLessCount(nums1, nums2[middle]);
            countLess = Math.max(countLess, 0);
            if (even && countLess == n - countLess || !even && Math.abs(countLess - (n - countLess)) == 1) {
                index = middle;
                break;
            }
            if (countLess > n - countLess) right = middle;
            else left = middle + 1;
        }
        if (index < 0) {
            int countLess = calculateLessCount(nums1, nums2[left]);
            countLess = Math.max(countLess, 0);
            if (even && countLess == n - countLess || !even && Math.abs(countLess - (n - countLess)) == 1) {
                index = left;
            }
        }
        if (!even) return nums2[index];
        int nextNumIndex = calculateLessCount2(nums1, nums2[index]);
        return (nums2[index] + nums1[nextNumIndex]) / 2d;
    }

    private int calculateLessCount(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] >= target) right = middle;
            else left = middle + 1;
        }
        if (left == 0 && nums[left] > target) return -1;
        return left + 1;
    }

    private int calculateLessCount2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) return middle;
            if (nums[middle] > target) right = middle;
            else left = middle + 1;
        }
        return left;
    }
}
