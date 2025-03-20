package matrix.workingPeoplesImitation.task_1512_Number_of_Good_Pairs;

import java.util.HashMap;
import java.util.Map;

// my solution
public class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int count = 0;
        for (int val : map.values()) {
            while (val-- > 0) {
                count += val;
            }
        }
        return count;
    }
}
