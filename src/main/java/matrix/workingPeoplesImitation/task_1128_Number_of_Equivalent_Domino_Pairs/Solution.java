package matrix.workingPeoplesImitation.task_1128_Number_of_Equivalent_Domino_Pairs;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// my solution
public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Domino, Integer> dominoesCount = new HashMap<>();
        Map<Domino, Integer> dominoesPairs = new HashMap<>();
        for (int[] dom : dominoes) {
            Domino d = new Domino(Math.min(dom[0], dom[1]), Math.max(dom[0], dom[1]));
            if (dominoesCount.containsKey(d)) {
                int prev = dominoesCount.get(d);
                dominoesPairs.merge(d, prev, Integer::sum);
            }
            dominoesCount.merge(d, 1, Integer::sum);
        }
        int ans = 0;
        for (int count : dominoesPairs.values()) {
            ans += count;
        }
        return ans;
    }

    static class Domino {
        int a;
        int b;

        public Domino(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Domino domino = (Domino) o;
            return a == domino.a && b == domino.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
