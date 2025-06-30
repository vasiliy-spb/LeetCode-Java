package matrix.workingPeoplesImitation.task_594_Longest_Harmonious_Subsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// my solution2
public class Solution2 {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
            frequencies.merge(num, 1, Integer::sum);
            if (stack.empty() || stack.peek() != num) {
                stack.push(num);
            }
        }
        int max = 0;
        while (stack.size() > 1) {
            int last = stack.pop();
            int prev = stack.peek();
            if (last - prev == 1) {
                max = Math.max(max, frequencies.get(last) + frequencies.get(prev));
            }
        }
        return max;
    }
}
