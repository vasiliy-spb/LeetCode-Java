package matrix.workingPeoplesImitation.task_719_Find_K_th_Smallest_Pair_Distance;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    // TLE
    public int smallestDistancePair0(int[] nums, int k) {
        Map<Integer, Integer> dist = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                dist.merge(Math.abs(nums[i] - nums[j]), 1, Integer::sum);
            }
        }
        for (int key : dist.keySet()) {
            if (k <= dist.get(key)) {
                return key;
            } else {
                k -= dist.get(key);
            }
        }
        return -1;
    }

    // my solution (after a bit hint from GPT)
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = Math.abs(nums[nums.length - 1] - nums[0]);
        while (left < right) {
            int middle = (left + right) / 2;
            int countSmallestDistance = calculateCountSmallestDistance(nums, middle);
            if (countSmallestDistance >= k) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    private int calculateCountSmallestDistance(int[] nums, int middle) {
        int count = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] - nums[i] <= middle) {
                j++;
            }
            count += j - i - 1;
        }
        return count;
    }

    // from walkccc.me
    public int smallestDistancePair2(int[] nums, int k) {
        Arrays.sort(nums);

        int l = 0;
        int r = nums[nums.length - 1] - nums[0];

        while (l < r) {
            final int m = (l + r) / 2;
            if (numPairDistancesNoGreaterThan(nums, m) >= k)
                r = m;
            else
                l = m + 1;
        }

        return l;
    }

    private int numPairDistancesNoGreaterThan(int[] nums, int m) {
        int count = 0;
        int j = 1;
        // For each index i, find the first index j s.t. nums[j] > nums[i] + m,
        // so numPairDistancesNoGreaterThan for the index i will be j - i - 1.
        for (int i = 0; i < nums.length; ++i) {
            while (j < nums.length && nums[j] <= nums[i] + m)
                ++j;
            count += j - i - 1;
        }
        return count;
    }

    // from leetcode editorial (Approach 1: Bucket Sort)
    public int smallestDistancePair3(int[] nums, int k) {
        int arrayLength = nums.length;

        // Find the maximum element in the array
        int maxElement = Integer.MIN_VALUE;
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }

        // Initialize a bucket array to store counts of each distance
        int[] distanceBucket = new int[maxElement + 1];

        // Populate the bucket array with counts of each distance
        for (int i = 0; i < arrayLength; ++i) {
            for (int j = i + 1; j < arrayLength; ++j) {
                // Compute the distance between nums[i] and nums[j]
                int distance = Math.abs(nums[i] - nums[j]);

                // Increment the count for this distance in the bucket
                ++distanceBucket[distance];
            }
        }

        // Find the k-th smallest distance
        for (int dist = 0; dist <= maxElement; ++dist) {
            // Reduce k by the number of pairs with the current distance
            k -= distanceBucket[dist];

            // If k is less than or equal to 0, return the current distance
            if (k <= 0) {
                return dist;
            }
        }

        return -1; // Return -1 if no distance found, should not reach here
    }

    // from leetcode editorial (Approach 2: Binary Search + Dynamic Programming (DP))
    public int smallestDistancePair4(int[] nums, int k) {
        Arrays.sort(nums);
        int arraySize = nums.length;
        int maxElement = nums[arraySize - 1];

        // Number of computed prefixes
        int prefixCountSize = maxElement * 2;

        // Initialize prefix counts and value counts
        int[] prefixCount = new int[prefixCountSize];
        int[] valueCount = new int[maxElement + 1];

        // Compute prefix counts and value counts
        int prefixIndex = 0;
        for (int value = 0; value < prefixCountSize; ++value) {
            while (prefixIndex < arraySize && nums[prefixIndex] <= value) {
                ++prefixIndex;
            }
            prefixCount[value] = prefixIndex;
        }
        for (int i = 0; i < arraySize; ++i) {
            ++valueCount[nums[i]];
        }

        // Binary search to find kth smallest distance
        int left = 0;
        int right = maxElement;
        while (left < right) {
            int middle = (left + right) / 2;

            // Compute number of pairs with distance <= middle
            int count = countPairs(nums, prefixCount, valueCount, middle);

            // Adjust bounds for binary search
            if (count < k) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }

    private int countPairs(
            int[] nums,
            int[] prefixCount,
            int[] valueCount,
            int maxDistance
    ) {
        int count = 0;
        int arraySize = nums.length;
        int index = 0;
        while (index < arraySize) {
            int currentValue = nums[index];
            int valueCountForCurrent = valueCount[currentValue];
            int pairsWithLargerValues =
                    prefixCount[Math.min(
                            currentValue + maxDistance,
                            prefixCount.length - 1
                    )] -
                            prefixCount[currentValue];
            int pairsWithSameValues =
                    (valueCountForCurrent * (valueCountForCurrent - 1)) / 2;
            count +=
                    pairsWithLargerValues * valueCountForCurrent + pairsWithSameValues;
            while (index + 1 < arraySize && nums[index] == nums[index + 1]) {
                ++index;
            }
            ++index;
        }
        return count;
    }

    // from leetcode editorial (Approach 3: Binary Search + Sliding Window)
    public int smallestDistancePair5(int[] nums, int k) {
        Arrays.sort(nums);
        int arraySize = nums.length;

        // Initialize binary search range
        int low = 0;
        int high = nums[arraySize - 1] - nums[0];

        while (low < high) {
            int mid = (low + high) / 2;

            // Count pairs with distance <= mid
            int count = countPairsWithMaxDistance(nums, mid);

            // Adjust binary search bounds based on count
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Count number of pairs with distance <= maxDistance using a moving window
    private int countPairsWithMaxDistance(int[] nums, int maxDistance) {
        int count = 0;
        int arraySize = nums.length;
        int left = 0;

        for (int right = 0; right < arraySize; ++right) {
            // Adjust the left pointer to maintain the window with distances <=
            // maxDistance
            while (nums[right] - nums[left] > maxDistance) {
                ++left;
            }
            // Add the number of valid pairs ending at the current right index
            count += right - left;
        }
        return count;
    }

}