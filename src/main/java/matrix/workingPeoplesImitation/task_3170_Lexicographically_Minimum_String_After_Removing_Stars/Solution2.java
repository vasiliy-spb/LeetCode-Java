package matrix.workingPeoplesImitation.task_3170_Lexicographically_Minimum_String_After_Removing_Stars;

import java.util.*;

// my solution 2
public class Solution2 {
    public String clearStars(String s) {
        PriorityQueue<Character> queue = new PriorityQueue<>();
        Stack<Integer>[] stacks = new Stack[26];
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                char min = queue.poll();
                int index = stacks[min - 'a'].pop();
                arr[index] = '\0';
                arr[i] = '\0';
            } else {
                queue.offer(ch);
                if (stacks[ch - 'a'] == null) {
                    stacks[ch - 'a'] = new Stack<>();
                }
                stacks[ch - 'a'].push(i);
                arr[i] = ch;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int numCh : arr) {
            if (numCh != 0) {
                ans.append((char) numCh);
            }
        }
        return ans.toString();
    }
}
