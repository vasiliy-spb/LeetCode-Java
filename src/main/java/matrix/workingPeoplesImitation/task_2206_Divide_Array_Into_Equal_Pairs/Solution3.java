package matrix.workingPeoplesImitation.task_2206_Divide_Array_Into_Equal_Pairs;

import java.util.HashMap;
import java.util.Map;

// from leetcode editorial (Approach 2: Map)
public class Solution3 {
    public boolean divideArray(int[] nums) {
        // Count frequency of each number
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // Check if each number appears even number of times
        for (int num : frequency.keySet()) {
            if (frequency.get(num) % 2 != 0) {
                return false;
            }
        }

        // All numbers can be paired
        return true;
    }
}
