package matrix.workingPeoplesImitation.task_904_Fruit_Into_Baskets;

import java.util.HashMap;
import java.util.Map;

// from walkccc.me
public class Solution2 {
    public int totalFruit(int[] fruits) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (int l = 0, r = 0; r < fruits.length; ++r) {
            count.merge(fruits[r], 1, Integer::sum);
            while (count.size() > 2) {
                count.merge(fruits[l], -1, Integer::sum);
                count.remove(fruits[l], 0);
                ++l;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
