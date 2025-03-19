package matrix.workingPeoplesImitation.task_3191_Minimum_Operations_to_Make_Binary_Array_Elements_Equal_to_One_I;

import java.util.ArrayDeque;
import java.util.Deque;

// from leetcode editorial (Approach 1: Using Deque)
public class Solution2 {
    public int minOperations(int[] nums) {
        Deque<Integer> flipQueue = new ArrayDeque<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!flipQueue.isEmpty() && i > flipQueue.peekFirst() + 2) {
                flipQueue.pollFirst();
            }

            if ((nums[i] + flipQueue.size()) % 2 == 0) {
                if (i + 2 >= nums.length) {
                    return -1;
                }
                count++;
                flipQueue.offerLast(i);
            }
        }

        return count;
    }
}
