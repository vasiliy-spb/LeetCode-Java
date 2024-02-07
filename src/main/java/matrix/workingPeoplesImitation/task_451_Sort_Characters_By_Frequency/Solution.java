package matrix.workingPeoplesImitation.task_451_Sort_Characters_By_Frequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // my solution (bucket sort approach)
    public String frequencySort(String s) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int ch : s.toCharArray())
            frequencyMap.merge(ch, 1, Integer::sum);
        List<Integer>[] buckets = new List[s.length() + 1];
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (buckets[frequency] == null) buckets[frequency] = new ArrayList<>();
            buckets[frequency].add(key);
        }
        StringBuilder result = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (int ch : buckets[i]) {
                    int count = i;
                    while (count-- > 0)
                        result.append((char) ch);
                }
            }
        }
        return result.toString();
    }

    // from walkccc.me
    public String frequencySort1(String s) {
        final int n = s.length();
        StringBuilder sb = new StringBuilder();
        int[] count = new int[128];
        // buckets[i] := characters that appear i times in s
        List<Character>[] buckets = new List[n + 1];

        for (final char c : s.toCharArray())
            ++count[c];

        for (int i = 0; i < 128; ++i) {
            final int freq = count[i];
            if (freq > 0) {
                if (buckets[freq] == null)
                    buckets[freq] = new ArrayList<>();
                buckets[freq].add((char) i);
            }
        }

        for (int freq = n; freq > 0; --freq)
            if (buckets[freq] != null)
                for (final char c : buckets[freq])
                    for (int i = 0; i < freq; ++i)
                        sb.append(c);

        return sb.toString();
    }

    // from GPT
    public static String frequencySort3(String s) {
        // Count the frequency of each character
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Create a list of characters and sort based on frequency
        List<Character> charList = new ArrayList<>(charFrequency.keySet());
        charList.sort((a, b) -> charFrequency.get(b) - charFrequency.get(a));

        // Build the result string
        StringBuilder result = new StringBuilder();
        for (char c : charList) {
            int frequency = charFrequency.get(c);
            for (int i = 0; i < frequency; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }

}
