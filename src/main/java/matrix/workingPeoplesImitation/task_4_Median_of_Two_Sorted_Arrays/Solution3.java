package matrix.workingPeoplesImitation.task_4_Median_of_Two_Sorted_Arrays;

public class Solution3 {

    // my solution (accepted)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        for (int i = 0, j = 0, ind = 0; i < nums1.length || j < nums2.length; ind++) {
            if (j == nums2.length) nums[ind] = nums1[i++];
            else if (i == nums1.length) nums[ind] = nums2[j++];
            else if (nums1[i] < nums2[j]) nums[ind] = nums1[i++];
            else if (nums1[i] >= nums2[j]) nums[ind] = nums2[j++];
        }
        if (nums.length % 2 == 1) return nums[nums.length / 2];
        return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2d;
    }

    // from leetcode editorial (Approach 1: Merge Sort)
    private int p1 = 0, p2 = 0;

    // Get the smaller value between nums1[p1] and nums2[p2] and move the pointer forwards.

    private int getMin(int[] nums1, int[] nums2) {
        if (p1 < nums1.length && p2 < nums2.length) {
            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        } else if (p1 < nums1.length) {
            return nums1[p1++];
        } else if (p2 < nums2.length) {
            return nums2[p2++];
        }
        return -1;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if ((m + n) % 2 == 0) {
            for (int i = 0; i < (m + n) / 2 - 1; ++i) {
                int tmp = getMin(nums1, nums2);
            }
            return (double) (getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
        } else {
            for (int i = 0; i < (m + n) / 2; ++i) {
                int tmp = getMin(nums1, nums2);
            }
            return getMin(nums1, nums2);
        }
    }

    // from leetcode editorial (Approach 2: Binary Search, Recursive)
    public double findMedianSortedArrays3(int[] A, int[] B) {
        int na = A.length, nb = B.length;
        int n = na + nb;
        if ((na + nb) % 2 == 1) {
            return solve(A, B, n / 2, 0, na - 1, 0, nb - 1);
        } else {
            return (
                    (double) (solve(A, B, n / 2, 0, na - 1, 0, nb - 1) +
                            solve(A, B, n / 2 - 1, 0, na - 1, 0, nb - 1)) /
                            2
            );
        }
    }

    public int solve(
            int[] A,
            int[] B,
            int k,
            int aStart,
            int aEnd,
            int bStart,
            int bEnd
    ) {
        // If the segment of on array is empty, it means we have passed all
        // its element, just return the corresponding element in the other array.
        if (aEnd < aStart) {
            return B[k - aStart];
        }
        if (bEnd < bStart) {
            return A[k - bStart];
        }

        // Get the middle indexes and middle values of A and B.
        int aIndex = (aStart + aEnd) / 2, bIndex = (bStart + bEnd) / 2;
        int aValue = A[aIndex], bValue = B[bIndex];

        // If k is in the right half of A + B, remove the smaller left half.
        if (aIndex + bIndex < k) {
            if (aValue > bValue) {
                return solve(A, B, k, aStart, aEnd, bIndex + 1, bEnd);
            } else {
                return solve(A, B, k, aIndex + 1, aEnd, bStart, bEnd);
            }
        }
        // Otherwise, remove the larger right half.
        else {
            if (aValue > bValue) {
                return solve(A, B, k, aStart, aIndex - 1, bStart, bEnd);
            } else {
                return solve(A, B, k, aStart, aEnd, bStart, bIndex - 1);
            }
        }
    }

    // from leetcode editorial (Approach 3: A Better Binary Search)
    public double findMedianSortedArrays4(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays4(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;

        while (left <= right) {
            int partitionA = (left + right) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            int maxLeftA = (partitionA == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partitionA - 1];
            int minRightA = (partitionA == m)
                    ? Integer.MAX_VALUE
                    : nums1[partitionA];
            int maxLeftB = (partitionB == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partitionB - 1];
            int minRightB = (partitionB == n)
                    ? Integer.MAX_VALUE
                    : nums2[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (
                            (Math.max(maxLeftA, maxLeftB) +
                                    Math.min(minRightA, minRightB)) /
                                    2.0
                    );
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                right = partitionA - 1;
            } else {
                left = partitionA + 1;
            }
        }
        return 0.0;
    }

    // from walkccc.me
    public double findMedianSortedArrays5(int[] nums1, int[] nums2) {
        final int n1 = nums1.length;
        final int n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays5(nums2, nums1);

        int l = 0;
        int r = n1;

        while (l <= r) {
            final int partition1 = (l + r) / 2;
            final int partition2 = (n1 + n2 + 1) / 2 - partition1;
            final int maxLeft1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            final int maxLeft2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
            final int minRight1 = partition1 == n1 ? Integer.MAX_VALUE : nums1[partition1];
            final int minRight2 = partition2 == n2 ? Integer.MAX_VALUE : nums2[partition2];
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1)
                return (n1 + n2) % 2 == 0
                        ? (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) * 0.5
                        : Math.max(maxLeft1, maxLeft2);
            else if (maxLeft1 > minRight2)
                r = partition1 - 1;
            else
                l = partition1 + 1;
        }

        throw new IllegalArgumentException();
    }

}
