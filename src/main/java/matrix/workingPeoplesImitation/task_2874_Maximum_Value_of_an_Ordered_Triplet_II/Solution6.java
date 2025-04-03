package matrix.workingPeoplesImitation.task_2874_Maximum_Value_of_an_Ordered_Triplet_II;

import java.util.LinkedList;

// from leetcode code sample (2)
public class Solution6 {
    public long maximumTripletValue(int[] nums) {
        LinkedList<Integer> ll = new LinkedList<>();
        int N = nums.length;
        for (int i = N - 1; i >= 1; i--) {
            if (ll.isEmpty() || nums[i] >= ll.peekFirst()) ll.offerFirst(nums[i]);
        }

        long max = nums[0];

        long ret = 0;
        for (int i = 1; i < N - 1; i++) {
            if (nums[i] == ll.peekFirst()) ll.pollFirst();

            ret = Math.max(ret, (max - nums[i]) * ll.peekFirst());
            max = Math.max(max, nums[i]);
        }
        return ret;
    }
}
