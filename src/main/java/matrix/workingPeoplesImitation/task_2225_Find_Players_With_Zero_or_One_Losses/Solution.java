package matrix.workingPeoplesImitation.task_2225_Find_Players_With_Zero_or_One_Losses;

import java.util.*;

public class Solution {

    // my solution
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> lossesCount = new TreeMap<>();
        for (int[] match : matches) {
            lossesCount.merge(match[0], 0, Integer::sum);
            lossesCount.merge(match[1], 1, Integer::sum);
        }
        List<Integer> winners = new ArrayList<>();
        List<Integer> oneLosses = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : lossesCount.entrySet()) {
            if (entry.getValue() == 0) winners.add(entry.getKey());
            if (entry.getValue() == 1) oneLosses.add(entry.getKey());
        }
        result.add(winners);
        result.add(oneLosses);
        return result;
    }

    // from leetcode solutions
    public List<List<Integer>> findWinners2(int[][] matches){
        Map<Integer, Integer> losses = new TreeMap<>();
        for(int[] m : matches){
            losses.put(m[0], losses.getOrDefault(m[0], 0));
            losses.put(m[1], losses.getOrDefault(m[1], 0) + 1);
        }
        List<List<Integer>> r = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for(Integer player : losses.keySet())
            if(losses.get(player) <= 1)
                r.get(losses.get(player)).add(player);
        return r;
    }
}
