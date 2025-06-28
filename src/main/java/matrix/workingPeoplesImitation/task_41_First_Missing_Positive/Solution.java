package matrix.workingPeoplesImitation.task_41_First_Missing_Positive;

import java.util.Set;
import java.util.TreeSet;

public class Solution {

    // my solution
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums)
            if (num > 0) set.add(num);
        int currentNum = 1;
        for (int num : set) {
            if (num != currentNum++) return --currentNum;
        }
        return set.size() + 1;
    }

    // from walkccc.me
    public int firstMissingPositive2(int[] nums) {
        final int n = nums.length;

        // Correct slot:
        // nums[i] = i + 1
        // nums[i] - 1 = i
        // nums[nums[i] - 1] = nums[i]
        for (int i = 0; i < n; ++i)
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);

        for (int i = 0; i < n; ++i)
            if (nums[i] != i + 1)
                return i + 1;

        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        final int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // from leetcode solutions
    //
    // All the questions where we need to find the repeating numbers, or missing numbers can easily be solved
    // with the help of a pattern that is cyclic sort. In this pattern we simply place the elements of the array
    // on their positions( or at least try to ), like 1 should be at 1st position and 2 at the second position,
    // and then we iterate again and check if for any index we have an element whose value is not equal to index + 1,
    // then that is the missing number.
    // You can follow this link to learn more (https://emre.me/coding-patterns/cyclic-sort/)
    // In this question we can simply ignore the -ve elements as we only need to find the smallest positive element,
    // so we ignore elements that are less than 0 and greater than arrays length
    // and swap only if the element is not at its correct posiition.
    // Then we iterate again and find the missing number and return it.
    //
    public int firstMissingPositive3(int[] nums) {
        int i = 0;
        while( i < nums.length){
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap2(nums,i,nums[i] - 1);
            }else{
                i++;
            }
        }
        for(i = 0;i<nums.length;i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap2(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // from leetcode solutions
    // The basic idea is to traversal and try to move the current value to position
    // whose index is exactly the value (swap them). Then travelsal again to find the first unusal value,
    // which can not be corresponding to its index.
    public int firstMissingPositive4(int[] nums) {

        int i = 0, n = nums.length;
        while (i < n) {
            // If the current value is in the range of (0,length) and it's not at its correct position,
            // swap it to its correct position.
            // Else just continue;
            if (nums[i] >= 0 && nums[i] < n && nums[nums[i]] != nums[i])
                swap3(nums, i, nums[i]);
            else
                i++;
        }
        int k = 1;

        // Check from k=1 to see whether each index and value can be corresponding.
        while (k < n && nums[k] == k)
            k++;

        // If it breaks because of empty array or reaching the end. K must be the first missing number.
        if (n == 0 || k < n)
            return k;
        else   // If k is hiding at position 0, K+1 is the number.
            return nums[0] == k ? k + 1 : k;

    }

    private void swap3(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // from GPT
    // This code uses the cyclic sort algorithm to rearrange the array elements so that each number i is at index i-1.
    // Then, it iterates through the sorted array to find the first position where the element
    // is not equal to its index + 1, and returns that value as the smallest missing positive integer.
    // If all numbers are in sequence, it returns the next positive integer after the length of the array.
    public static int firstMissingPositive5(int[] nums) {
        int n = nums.length;

        // Perform cyclic sort
        for (int i = 0; i < n; i++) {
            // Keep swapping until the current element is in its correct position
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        // Find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                // The first position where nums[i] != i + 1 is the smallest missing positive integer
                return i + 1;
            }
        }
        // If all numbers are in sequence, return the next positive integer after the length of the array
        return n + 1;
    }
}
