package matrix.workingPeoplesImitation.task_692_Top_K_Frequent_Words;

import java.util.*;

public class Solution {

    // my solution (bucket sort approach)
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words)
            frequencyMap.merge(word, 1, Integer::sum);

        PriorityQueue<String> buckets = new PriorityQueue<>((s1, s2) ->
                frequencyMap.get(s1).equals(frequencyMap.get(s2)) ?
                        s1.compareTo(s2) : frequencyMap.get(s2) - frequencyMap.get(s1));

        buckets.addAll(frequencyMap.keySet());

        List<String> result = new ArrayList<>();
        while(!buckets.isEmpty() && k-- > 0) {
            result.add(buckets.poll());
        }

        return result;
    }

    // my solution (bucket sort approach)
    public List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words)
            frequencyMap.merge(word, 1, Integer::sum);
        TreeSet<String>[] buckets = new TreeSet[words.length + 1];
        for (String key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (buckets[frequency] == null) buckets[frequency] = new TreeSet<>();
            buckets[frequency].add(key);
        }
        List<String> result = new ArrayList<>();
        one: for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                Set<String> set = buckets[i];
                for (String word : set) {
                    if (k-- == 0) break one;
                    result.add(word);
                }
            }
        }
        return result;
    }
}
