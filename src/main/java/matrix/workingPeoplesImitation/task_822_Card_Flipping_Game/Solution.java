package matrix.workingPeoplesImitation.task_822_Card_Flipping_Game;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

// my solution
public class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> similar = new HashSet<>();
        int n = fronts.length;
        Set<Integer> other = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int front = fronts[i];
            int back = backs[i];
            if (front == back) {
                similar.add(front);
            }
            if (!similar.contains(front)) {
                other.add(front);
            }
            if (!similar.contains(back)) {
                other.add(back);
            }
        }

        return other.stream()
                .filter(num -> !similar.contains(num))
                .sorted(Comparator.naturalOrder())
                .findFirst()
                .orElse(0);
    }
}
