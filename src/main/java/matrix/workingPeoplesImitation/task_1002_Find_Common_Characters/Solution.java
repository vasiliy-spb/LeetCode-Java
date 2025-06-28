package matrix.workingPeoplesImitation.task_1002_Find_Common_Characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> commonChars(String[] words) {
        List<Map<Character, Integer>> mapList = new ArrayList<>();
        for (String word : words) {
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : word.toCharArray()) {
                map.merge(ch, 1, Integer::sum);
            }
            mapList.add(map);
        }
        List<String> result = new ArrayList<>();
        for (char ch : mapList.get(0).keySet()) {
            int count = mapList.get(0).get(ch);
            for (int i = 1; i < mapList.size(); i++) {
                count = Math.min(count, mapList.get(i).getOrDefault(ch, 0));
            }
            while (count > 0) {
                result.add(ch +  "");
                count--;
            }
        }
        return result;
    }
}
