package matrix.workingPeoplesImitation.task_398_Random_Pick_Index;

import java.util.*;

// my solution
public class Solution {
    Map<Integer, List<Integer>> numMap;
    public Solution(int[] nums) {
        this.numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.computeIfAbsent(nums[i], list -> new ArrayList<>()).add(i);
        }
    }

    public int pick(int target) {
        Random random = new Random();
        return numMap.get(target).get(random.nextInt(numMap.get(target).size()));
    }
}
