package matrix.workingPeoplesImitation.task_2391_Minimum_Amount_of_Time_to_Collect_Garbage;

import java.util.HashMap;
import java.util.Map;

// my solution
public class Solution {

    // fast solution
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int[] prefixSum = new int[n];
        for (int i = 0; i < n - 1; i++) {
            prefixSum[i + 1] = travel[i] + prefixSum[i];
        }
        int time = 0;
        char[] trucks = {'M', 'P', 'G'};
        Map<Character, Integer> finish = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            time += garbage[i].length();
            if (finish.size() == 3) continue;
            for (char g : garbage[i].toCharArray()) {
                finish.putIfAbsent(g, i);
            }
        }
        for (char truck : trucks) {
            time += prefixSum[finish.getOrDefault(truck, 0)];
        }
        return time;
    }

    // slow solution
    public int garbageCollection0(String[] garbage, int[] travel) {
        int time = 0;
        char[] trucks = {'M', 'P', 'G'};
        for (char truck : trucks) {
            int distance = 0;
            for (int i = 0; i < garbage.length; i++) {
                if (i > 0) {
                    distance += travel[i - 1];
                }
                if (garbage[i].indexOf(truck) >= 0) {
                    for (char g : garbage[i].toCharArray()) {
                        if (g == truck) {
                            time++;
                        }
                    }
                    time += distance;
                    distance = 0;
                }
            }
        }
        return time;
    }
}
