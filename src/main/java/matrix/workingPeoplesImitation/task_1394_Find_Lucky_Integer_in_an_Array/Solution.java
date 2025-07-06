package matrix.workingPeoplesImitation.task_1394_Find_Lucky_Integer_in_an_Array;

import java.util.HashMap;
import java.util.Map;

// my solution
public class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int a : arr) {
            frequencies.merge(a, 1, Integer::sum);
        }
        int ans = -1;
        for (int a : arr) {
            if (frequencies.get(a) == a) {
                ans = Math.max(ans, a);
            }
        }
        return ans;
    }
}
