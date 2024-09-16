package matrix.workingPeoplesImitation.task_1282_Group_the_People_Given_the_Group_Size_They_Belong_To;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// my solution
public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            map.computeIfAbsent(groupSize, list -> new ArrayList<>()).add(i);
            if (map.get(groupSize).size() == groupSize) {
                ans.add(map.remove(groupSize));
            }
        }
        return ans;
    }
}
