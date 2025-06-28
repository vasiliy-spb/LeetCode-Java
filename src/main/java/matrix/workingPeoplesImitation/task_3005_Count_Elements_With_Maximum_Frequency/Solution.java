package matrix.workingPeoplesImitation.task_3005_Count_Elements_With_Maximum_Frequency;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
            maxFrequency = Math.max(maxFrequency, map.get(num));
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() == maxFrequency) count += maxFrequency;
        return count;
    }
}
