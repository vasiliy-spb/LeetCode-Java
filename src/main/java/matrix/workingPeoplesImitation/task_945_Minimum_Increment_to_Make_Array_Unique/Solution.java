package matrix.workingPeoplesImitation.task_945_Minimum_Increment_to_Make_Array_Unique;

import java.util.*;

// my solution
public class Solution {
    public int minIncrementForUnique(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        int nextMax = nums[nums.length - 1] + 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (set.contains(num)) {
                if (stack.empty()) {
                    count += nextMax - num;
                    set.add(nextMax++);
                } else {
                    int current = stack.pop();
                    count += current - num;
                    set.add(current);
                }
            } else {
                if (i < nums.length - 1) {
                    for (int j = nums[i + 1] - 1; j > num; j--) {
                        stack.push(j);
                    }
                }
                set.add(num);
            }
        }
        return count;
    }
}
