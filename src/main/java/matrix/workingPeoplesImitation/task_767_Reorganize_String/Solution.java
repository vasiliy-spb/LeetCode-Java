package matrix.workingPeoplesImitation.task_767_Reorganize_String;

import java.util.PriorityQueue;
import java.util.Queue;

// my solution
public class Solution {
    public String reorganizeString(String s) {
        int[] letters = new int[26];
        for (char ch : s.toCharArray()) {
            letters[ch - 'a']++;
        }
        Queue<Letter> queue = new PriorityQueue<>((l1, l2) -> Integer.compare(l2.count, l1.count));
        for (int i = 0; i < 26; i++) {
            if (letters[i] == 0) {
                continue;
            }
            queue.offer(new Letter((char)(i + 'a'), letters[i]));
        }
        StringBuilder ans = new StringBuilder();
        char prev = '\0';
        while (!queue.isEmpty()) {
            Letter top = queue.poll();
            if (top.value == prev) {
                if (queue.isEmpty()) {
                    return "";
                }
                ans.append(queue.peek().value);
                prev = queue.peek().value;
                queue.peek().count--;
                if (queue.peek().count == 0) {
                    queue.poll();
                }
                queue.offer(top);
            } else {
                ans.append(top.value);
                prev = top.value;
                top.count--;
                if (top.count > 0) {
                    queue.offer(top);
                }
            }
        }
        return ans.toString();
    }
    static class Letter {
        char value;
        int count;
        public Letter(char value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
