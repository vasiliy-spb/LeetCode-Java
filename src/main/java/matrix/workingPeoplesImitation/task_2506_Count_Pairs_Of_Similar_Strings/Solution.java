package matrix.workingPeoplesImitation.task_2506_Count_Pairs_Of_Similar_Strings;

import java.util.HashMap;
import java.util.Map;

// my solution
public class Solution {
    public int similarPairs(String[] words) {
        Map<Integer, Integer> maskMap = new HashMap<>();
        int countSimilarPair = 0;
        for (String word : words) {
            int mask = getMask(word);
            countSimilarPair += maskMap.getOrDefault(mask, 0);
            maskMap.merge(mask, 1, Integer::sum);
        }
        return countSimilarPair;
    }
    private int getMask(String word) {
        int mask = 0;
        for (char letter : word.toCharArray()) {
            int position = 1 << letter - 'a';
            mask |= position;
        }
        return mask;
    }
}
