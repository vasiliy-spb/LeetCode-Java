package matrix.workingPeoplesImitation.task_1128_Number_of_Equivalent_Domino_Pairs;

import java.util.HashMap;
import java.util.Map;

// from walkccc.me
public class Solution3 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (int[] domino : dominoes) {
            int key = Math.min(domino[0], domino[1]) * 10 + Math.max(domino[0], domino[1]);
            ans += count.getOrDefault(key, 0);
            count.merge(key, 1, Integer::sum);
        }

        return ans;
    }
}
