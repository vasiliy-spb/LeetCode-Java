package matrix.workingPeoplesImitation.task_2391_Minimum_Amount_of_Time_to_Collect_Garbage;

import java.util.HashMap;
import java.util.Map;

// from leetcode editorial (Approach 1: HashMap)
public class Solution4 {
    public int garbageCollection(String[] garbage, int[] travel) {
        // Array to store the prefix sum in travel.
        int[] prefixSum = new int[travel.length + 1];
        prefixSum[1] = travel[0];
        for (int i = 1; i < travel.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + travel[i];
        }

        // Map to store garbage type to the last house index.
        Map<Character, Integer> garbageLastPos = new HashMap<Character, Integer>();

        // Map to store the total count of each type of garbage in all houses.
        Map<Character, Integer>garbageCount = new HashMap<Character, Integer>();
        for (int i = 0; i < garbage.length; i++) {
            for (char c : garbage[i].toCharArray()) {
                garbageLastPos.put(c, i);
                garbageCount.put(c, garbageCount.getOrDefault(c, 0) + 1);
            }
        }

        String garbageTypes = "MPG";
        int ans = 0;
        for (char c : garbageTypes.toCharArray()) {
            // Add only if there is at least one unit of this garbage.
            if (garbageCount.containsKey(c)) {
                ans += prefixSum[garbageLastPos.get(c)] + garbageCount.get(c);
            }
        }

        return ans;
    }
}
