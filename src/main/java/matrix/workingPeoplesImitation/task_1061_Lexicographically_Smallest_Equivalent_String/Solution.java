package matrix.workingPeoplesImitation.task_1061_Lexicographically_Smallest_Equivalent_String;

import java.util.*;

// my solution
public class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        boolean[][] matrix = new boolean[26][26];
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            matrix[ch1 - 'a'][ch1 - 'a'] = true;
            matrix[ch2 - 'a'][ch2 - 'a'] = true;
            matrix[ch1 - 'a'][ch2 - 'a'] = true;
            matrix[ch2 - 'a'][ch1 - 'a'] = true;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            char ch = baseStr.charAt(i);
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new ArrayDeque<>();
            for (int j = 0; j < 26; j++) {
                if (matrix[ch - 'a'][j]) {
                    queue.offer(j);
                }
            }
            int min = ch - 'a';
            while (!queue.isEmpty()) {
                int current = queue.poll();
                min = Math.min(min, current);
                visited.add(current);
                for (int j = 0; j < 26; j++) {
                    if (matrix[current][j] && !visited.contains(j)) {
                        queue.offer(j);
                    }
                }
            }
            ans.append((char) (min + 'a'));
        }
        return ans.toString();
    }
}
