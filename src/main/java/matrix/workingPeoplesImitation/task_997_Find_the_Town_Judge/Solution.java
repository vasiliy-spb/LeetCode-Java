package matrix.workingPeoplesImitation.task_997_Find_the_Town_Judge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    // my solution
    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return n;
        Map<Integer, Set<Integer>> trustMap = new HashMap<>();
        Set<Integer> people = new HashSet<>();
        for (int i = 0; i < trust.length; i++) {
            trustMap.computeIfAbsent(trust[i][1], set -> new HashSet<>()).add(trust[i][0]);
            people.add(trust[i][0]);
        }
        for (Map.Entry<Integer, Set<Integer>> entry : trustMap.entrySet()) {
            if (entry.getValue().size() == n - 1 && !people.contains(entry.getKey())) return entry.getKey();
        }
        return -1;
    }

    // from walkccc.me
    public int findJudge2(int n, int[][] trust) {
        int[] count = new int[n + 1];

        for (int[] t : trust) {
            --count[t[0]];
            ++count[t[1]];
        }

        for (int i = 1; i < n + 1; ++i)
            if (count[i] == n - 1)
                return i;

        return -1;
    }
}
