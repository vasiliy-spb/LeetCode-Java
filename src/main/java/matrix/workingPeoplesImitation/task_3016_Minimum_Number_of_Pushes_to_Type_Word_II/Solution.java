package matrix.workingPeoplesImitation.task_3016_Minimum_Number_of_Pushes_to_Type_Word_II;

import java.util.*;

public class Solution {

    // my solution
    public int minimumPushes(String word) {
        int result = 0;
        int[] frequency = new int[26];

        for (char ch : word.toCharArray())
            frequency[ch - 'a']++;

        Arrays.sort(frequency);

        for (int i = frequency.length - 1; i >= 0; i--)
            result += ((frequency.length - 1 - i) / 8 + 1) * frequency[i];

        return result;
    }

    // my solution
    public int minimumPushes0(String word) {
        int result = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (char ch : word.toCharArray())
            frequencyMap.merge((int) ch, 1, Integer::sum);
        List<Integer> list = frequencyMap.values().stream().sorted((a, b) -> b - a).toList();
        for (int i = 0; i < list.size(); i++) {
            result += (i / 8 + 1) * list.get(i);
        }
        return result;
    }
}