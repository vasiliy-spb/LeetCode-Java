package matrix.workingPeoplesImitation.task_904_Fruit_Into_Baskets;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

// my solution
public class Solution {
    public int totalFruit(int[] fruits) {
        int count = 0;
        Map<Integer, Integer> bucket = new HashMap<>();
        for (int left = 0, right = 0; right < fruits.length; right++) {
            bucket.merge(fruits[right], 1, Integer::sum);
            if (bucket.size() <= 2) {
                count = Math.max(count, right - left + 1);
            }
            while (bucket.size() > 2) {
                bucket.merge(fruits[left], -1, Integer::sum);
                if (bucket.get(fruits[left]) == 0) {
                    bucket.remove(fruits[left]);
                }
                left++;
            }
        }
        return count;
    }
}
