package matrix.workingPeoplesImitation.task_1509_Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves;

import java.util.*;

public class Solution {

    // my solution (with hint by GPT)
    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        int a = Math.abs(nums[left + 3] - nums[right]);
        int b = Math.abs(nums[left + 2] - nums[right - 1]);
        int c = Math.abs(nums[left + 1] - nums[right - 2]);
        int d = Math.abs(nums[left] - nums[right - 3]);
        return Math.min(Math.min(a, b), Math.min(c, d));
    }

//    public int minDifference0(int[] nums) { // 1, 5, 6, 14, 15
//        if (nums.length <= 4) return 0;
//        Arrays.sort(nums);
//        System.out.println("nums = " + Arrays.toString(nums));
//
//        int left = 0;
//        int right = nums.length - 1;
//
//        int count = 3;
//        while (count > 0) {
//            int l = Math.abs(nums[left] - nums[left + 1]);
//            int r = Math.abs(nums[right] - nums[right - 1]);
//
//            if (l > r) left++;
//            else if (l < r) right--;
//            else {
//                if (left + 1 >= right - 1) left++;
//                else {
//                    int le = Math.abs(nums[left + 1] - nums[left + 2]);
//                    int ri = Math.abs(nums[right - 1] - nums[right - 2]);
//                    if (le > ri) left += count > 1 ? 2 : 1;
//                    else if (le < ri) right -= count > 1 ? 2 : 1;
//                    else {
//                        if (left + 2 >= right - 2) left += 2;
//                        else {
//                            int lef = Math.abs(nums[left + 1] - nums[left + 2]);
//                            int rig = Math.abs(nums[right - 1] - nums[right - 2]);
//                            if (lef > rig) left += count > 2 ? 3 : 2;
//                            else if (lef < rig) right -= count > 2 ? 3 : 2;
//                        }
//                        count--;
//                    }
//                }
//                count--;
//            }
//            count--;
//        }
//        return Math.abs(nums[left] - nums[right]);
//    }

    // from leetcode editorial (Approach 1: Sort + Greedy Deletion)
    public int minDifference2(int[] nums) {
        int numsSize = nums.length;

        // If the array has 4 or fewer elements, return 0
        if (numsSize <= 4) return 0;

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        // Four scenarios to compute the minimum difference
        for (int left = 0, right = numsSize - 4; left < 4; left++, right++) {
            minDiff = Math.min(minDiff, nums[right] - nums[left]);
        }

        return minDiff;
    }

    // from leetcode editorial (Approach 2: Partial Sort + Greedy Deletion)
    public int minDifference3(int[] nums) {
        int numsSize = nums.length;
        if (numsSize <= 4) {
            return 0;
        }

        // Find the four smallest elements using a fixed-size max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                Collections.reverseOrder()
        );
        for (int num : nums) {
            maxHeap.offer(num);
            if (maxHeap.size() > 4) {
                maxHeap.poll();
            }
        }
        List<Integer> smallestFour = new ArrayList<>(maxHeap);
        Collections.sort(smallestFour);

        // Find the four largest elements using a fixed-size min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > 4) {
                minHeap.poll();
            }
        }
        List<Integer> largestFour = new ArrayList<>(minHeap);
        Collections.sort(largestFour);

        int minDiff = Integer.MAX_VALUE;
        // Four scenarios to compute the minimum difference
        for (int i = 0; i < 4; i++) {
            minDiff = Math.min(
                    minDiff,
                    largestFour.get(i) - smallestFour.get(i)
            );
        }

        return minDiff;
    }

    // from walkccc.me
    public int minDifference4(int[] nums) {
        final int n = nums.length;
        if (n < 5)
            return 0;

        int ans = Integer.MAX_VALUE;

        Arrays.sort(nums);

        // 1. Change nums[0..i) to nums[i].
        // 2. Change nums[n - 3 + i..n) to nums[n - 4 + i].
        for (int i = 0; i <= 3; ++i)
            ans = Math.min(ans, nums[n - 4 + i] - nums[i]);

        return ans;
    }

}


/*

1 2 3 8 10 12

1 3 5 10 12


 */