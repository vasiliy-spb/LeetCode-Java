package matrix.workingPeoplesImitation.task_1925_Count_Square_Sum_Triples;

import java.util.HashSet;
import java.util.Set;

// from walkccc.me
public class Solution5 {
    public int countTriples(int n) {
        int ans = 0;
        Set<Integer> squared = new HashSet<>();

        for (int i = 1; i <= n; ++i) {
            squared.add(i * i);
        }

        for (final int a : squared) {
            for (final int b : squared) {
                if (squared.contains(a + b)) {
                    ++ans;
                }
            }
        }

        return ans;
    }
}
