package matrix.workingPeoplesImitation.task_763_Partition_Labels;

import java.util.*;

// my solution
public class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = 0;
        int end = 0;

        for (char ch : s.toCharArray()) {
            int lastIndex = last[ch - 'a'];
            end = Math.max(end, lastIndex);
            if (right == end) {
                ans.add(right - left + 1);
                left = right + 1;
            }
            right++;
        }
        return ans;
    }
}
