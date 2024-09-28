package matrix.workingPeoplesImitation.task_179_Largest_Number;

// from leetcode editorial (Approach 2: Quick Sort)
public class Solution5 {
    public String largestNumber(int[] nums) {
        // Sort the numbers using Quick Sort
        quickSort(nums, 0, nums.length - 1);
        // Concatenate sorted numbers to form the largest number
        StringBuilder largestNum = new StringBuilder();
        for (int num : nums) {
            largestNum.append(num);
        }
        // Handle the case where the largest number is zero
        return largestNum.charAt(0) == '0' ? "0" : largestNum.toString();
    }

    private void quickSort(int[] nums, int left, int right) {
        // Base case: if the range has one or no elements, it is already sorted
        if (left >= right) return;
        // Partition the array and get the pivot index
        int pivotIndex = partition(nums, left, right);
        // Recursively sort the sub-arrays
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int lowIndex = left;
        // Rearrange elements so that those greater than the pivot are on the left
        for (int i = left; i < right; ++i) {
            if (compare(nums[i], pivot)) {
                swap(nums, i, lowIndex);
                ++lowIndex;
            }
        }
        // Place the pivot in its correct position
        swap(nums, lowIndex, right);
        return lowIndex;
    }

    private boolean compare(int firstNum, int secondNum) {
        // Compare concatenated strings to decide the order
        String str1 = String.valueOf(firstNum) + String.valueOf(secondNum);
        String str2 = String.valueOf(secondNum) + String.valueOf(firstNum);
        return str1.compareTo(str2) > 0;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
