package matrix.workingPeoplesImitation.task_4_Median_of_Two_Sorted_Arrays;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean even = (nums1.length + nums2.length) % 2 == 0;
        double result = findIndex(nums1, nums2, true, even);
        if (Double.isNaN(result)) result = findIndex(nums1, nums2, false, even);
        return result;
    }

    public double findIndex(int[] nums1, int[] nums2, boolean firstArray, boolean even) {
        int[] nums = firstArray ? nums1 : nums2;
        int left = 0;
        int right = nums.length - 1;
        double result = 0;
        while (left < right) {
            int middle = (left + right) / 2;
            result = calculateMedian(nums1, nums2, firstArray, even, middle);
            if (result > 0) right = middle;
            else left = middle + 1;
        }
        if (result == Double.MAX_VALUE || result == Double.MIN_VALUE) return Double.NaN;
        return result;
    }

    private double calculateMedian(int[] nums1, int[] nums2, boolean firstArray, boolean even, int middle) {
        int add = even ? 0 : 1;
        int countLeft = 0;
        int countRight = 0;
        int firstMaxIndex;
        if (firstArray) {
            countLeft += middle;
            countRight += nums1.length - middle - 1;
            if (nums2[0] > nums1[middle]) {
                countRight += nums2.length;
            } else if (nums2[nums2.length - 1] < nums1[middle]) {
                countLeft += nums2.length;
            } else {
                firstMaxIndex = searchFirstMaxIndex(nums2, nums1[middle]);
                countLeft += Math.max(firstMaxIndex - 1, 0);
                countRight += nums2.length - firstMaxIndex - 1;
                if (nums2[firstMaxIndex] == nums1[middle]) {
                    if (countLeft > countRight) countRight++;
                    else countLeft++;
                } else {
                    countRight++;
                }
            }
        } else {
            countLeft += middle + 1 - add;
            countRight += nums2.length - middle - add;
            if (nums1[0] > nums2[middle]) {
                countRight += nums1.length;
            } else if (nums1[nums1.length - 1] < nums2[middle]) {
                countLeft += nums1.length;
            } else {
                firstMaxIndex = searchFirstMaxIndex(nums2, nums1[middle]);
                countLeft += Math.max(firstMaxIndex - 1, 0);
                countRight += nums1.length - firstMaxIndex - 1;
                if (nums1[firstMaxIndex] == nums2[middle]) {
                    if (countLeft > countRight) countRight++;
                    else countLeft++;
                } else {
                    countRight++;
                }
            }
        }
        if (!even && countLeft == countRight) return firstArray ? nums1[middle] : nums2[middle];
        if (even && Math.abs(countRight - countLeft) == 1) {
            if (countLeft > countRight) {
                if (firstArray) {
                    int firstMaxOne = searchFirstMax(nums1, nums1[middle]);
                    int firstMaxTwo = searchFirstMax(nums2, nums1[middle]);
                    return (Math.min(firstMaxOne, firstMaxTwo) + nums1[middle]) / 2d;
                } else {
                    int firstMaxOne = searchFirstMax(nums1, nums2[middle]);
                    int firstMaxTwo = searchFirstMax(nums2, nums2[middle]);
                    return (Math.min(firstMaxOne, firstMaxTwo) + nums2[middle]) / 2d;
                }
            } else {
                if (firstArray) {
                    int firstMaxOne = searchFirstMin(nums1, nums1[middle]);
                    int firstMaxTwo = searchFirstMin(nums2, nums1[middle]);
                    return (Math.min(firstMaxOne, firstMaxTwo) + nums1[middle]) / 2d;
                } else {
                    int firstMaxOne = searchFirstMin(nums1, nums2[middle]);
                    int firstMaxTwo = searchFirstMin(nums2, nums2[middle]);
                    return (Math.min(firstMaxOne, firstMaxTwo) + nums2[middle]) / 2d;
                }
            }
        }
        return countLeft > countRight ? Double.MAX_VALUE : Double.MIN_VALUE;
    }

    private int searchFirstMin(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) return nums[middle - 1];
            if (nums[middle] > target) right = middle;
            else left = middle + 1;
        }
        return nums[left - 1];
    }

    private int searchFirstMax(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) return nums[middle + 1];
            if (nums[middle] > target) right = middle;
            else left = middle + 1;
        }
        return nums[left];
    }

    private int searchFirstMaxIndex(int[] nums, int target) {
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

/*

1 2 3 4
6 7 8 9

1 2 3 4
3 4 5 6

1 2 3 4 5 6
1

1 2 3 4 5 6
6

1 2 3 4 5 6
-3

1 2 3 4 5 6
8

1 2 5 6
3 4

1 2 5 6
2 5

1 2 3
4 5 6 7 8

1 2 3
4 5 6 7

1 2 3 4 5
6 7 8

1 2 3 4 5
6 7

2 3 4 5
1 7

2 3 6 7
1 4 5 8

2 3 5 7
1 4 6 8

2 3 5 7
1 4 8

2 3 5 7
1 4 5 8

 */
