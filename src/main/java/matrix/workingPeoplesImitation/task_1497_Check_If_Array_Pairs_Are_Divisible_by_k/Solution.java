package matrix.workingPeoplesImitation.task_1497_Check_If_Array_Pairs_Are_Divisible_by_k;

import java.util.HashMap;
import java.util.Map;

// my solution
public class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.merge(((a % k) + k) % k, 1, Integer::sum); // ((a % k) + k) % k — чтобы все были положительные
        }

        for (int key : map.keySet()) {
            if (key == 0) {
                continue;
            }
            if (map.get(key) == 0) {
                continue;
            }
            int count = map.get(key);
            int countComplementary = map.getOrDefault(key > 0 ? k - key : -(k + key), 0);
            if (key * 2 == k) {
                if (count % 2 != 0) {
                    return false;
                }
            }
            if (count != countComplementary) {
                return false;
            }
        }
        return true;
    }
}
