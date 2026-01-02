package matrix.workingPeoplesImitation.task_961_N_Repeated_Element_in_Size_2N_Array;

import java.util.HashMap;
import java.util.Map;

// from leetcode editorial (Approach 1: Count)
public class Solution2 {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : A) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        for (int k : count.keySet()) {
            if (count.get(k) > 1) {
                return k;
            }
        }

        throw null;
    }
}
