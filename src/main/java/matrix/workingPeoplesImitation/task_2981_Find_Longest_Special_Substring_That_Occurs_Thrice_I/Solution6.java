package matrix.workingPeoplesImitation.task_2981_Find_Longest_Special_Substring_That_Occurs_Thrice_I;

import java.util.HashMap;
import java.util.PriorityQueue;

// from leetcode code sample (4)
public class Solution6 {
    public int maximumLength(String s) {
        int i = 0;
        HashMap<Character, PriorityQueue<Integer>> map = new HashMap<>();
        while (i < s.length()) {
            char c = s.charAt(i);
            int count = 1;
            PriorityQueue pq = map.getOrDefault(c, new PriorityQueue<Integer>((a, b) -> b - a));
            pq.add(count);
            i++;

            while (i < s.length() && s.charAt(i) == c) {
                count++;
                i++;
                pq.add(count);
            }
            map.put(c, pq);
        }

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int max = -1;

        for (i = 0; i < alphabet.length(); i++) {
            PriorityQueue pq = map.getOrDefault(alphabet.charAt(i), new PriorityQueue<Integer>());
            if (pq.size() >= 3) {
                pq.poll();
                pq.poll();
                Integer count = (Integer) pq.peek();
                max = Math.max(count, max);
            }
        }
        return max;
    }
}
