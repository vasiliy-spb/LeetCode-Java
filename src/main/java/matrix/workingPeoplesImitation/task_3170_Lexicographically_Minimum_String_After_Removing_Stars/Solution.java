package matrix.workingPeoplesImitation.task_3170_Lexicographically_Minimum_String_After_Removing_Stars;

import java.util.*;
import java.util.stream.Collectors;

// my solution
public class Solution {
    public String clearStars(String s) {
        TreeMap<Character, Stack<Integer>> indexMap = new TreeMap<>();
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                Map.Entry<Character, Stack<Integer>> entry = indexMap.firstEntry();
                Stack<Integer> stack = entry.getValue();
                int index = stack.pop();
                arr[index] = '\0';
                arr[i] = '\0';
                if (stack.empty()) {
                    indexMap.remove(entry.getKey());
                }
            } else {
                indexMap.computeIfAbsent(ch, stack -> new Stack<>()).push(i);
                arr[i] = ch;
            }
        }
        return Arrays.stream(arr)
                .filter(i -> i != 0)
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.joining());
    }
}
