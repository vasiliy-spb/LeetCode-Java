package matrix.workingPeoplesImitation.task_2418_Sort_the_People;

import java.util.Comparator;
import java.util.TreeMap;

public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        return map.values().toArray(new String[0]);
    }
}
