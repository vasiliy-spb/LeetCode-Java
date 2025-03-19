package matrix.workingPeoplesImitation.task_2206_Divide_Array_Into_Equal_Pairs;

import java.util.HashMap;
import java.util.Map;

// my solution
public class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }
        for (int frequency : frequencyMap.values()) {
            if (frequency % 2 == 1) {
                return false;
            }
        }
        return true;
    }
}
