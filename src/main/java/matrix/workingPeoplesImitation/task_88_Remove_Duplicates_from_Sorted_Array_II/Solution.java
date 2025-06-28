package matrix.workingPeoplesImitation.task_88_Remove_Duplicates_from_Sorted_Array_II;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int correctPosition = 0;
        int currentIndex = 0;
        int currentCount = 1;
        int prev = 100000;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == prev) {
                if (currentCount < 2) nums[correctPosition++] = nums[currentIndex];
                currentCount++;
            } else {
                currentIndex = i;
                nums[correctPosition++] = nums[currentIndex];
                currentCount = 1;
            }
            prev = nums[i];
        }
        return correctPosition;
    }
}
