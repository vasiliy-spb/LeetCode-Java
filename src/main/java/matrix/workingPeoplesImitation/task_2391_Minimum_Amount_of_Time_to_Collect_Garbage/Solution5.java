package matrix.workingPeoplesImitation.task_2391_Minimum_Amount_of_Time_to_Collect_Garbage;

import java.util.HashMap;
import java.util.Map;

// from leetcode editorial (Approach 2: HashMap and In-place Modification)
public class Solution5 {
    public int garbageCollection(String[] garbage, int[] travel) {
        // Store the prefix sum in travel itself.
        for (int i = 1; i < travel.length; i++) {
            travel[i] = travel[i - 1] + travel[i];
        }

        // Map to store garbage type to the last house index.
        Map<Character, Integer> garbageLastPos = new HashMap<Character, Integer>();
        int ans = 0;
        for (int i = 0; i < garbage.length; i++) {
            for (char c : garbage[i].toCharArray()) {
                garbageLastPos.put(c, i);
            }
            ans += garbage[i].length();
        }

        String garbageTypes = "MPG";
        for (char c : garbageTypes.toCharArray()) {
            // No travel time is required if the last house is at index 0.
            ans += (garbageLastPos.getOrDefault(c, 0) == 0 ? 0 : travel[garbageLastPos.get(c) - 1]);
        }

        return ans;
    }
}