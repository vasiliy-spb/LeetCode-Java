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
    public List<Integer> partitionLabels1(String s) {
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndexMap.put(s.charAt(i), i);
        }
        List<Integer> ans = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int end = 0;
        set.add(s.charAt(0));

        for (char ch : s.toCharArray()) {
            if (set.size() == 0) {
                left = right;
            }
            int lastIndex = lastIndexMap.get(ch);
            end = Math.max(end, lastIndex);
            set.add(ch);
            if (right == end) {
                set = new HashSet<>();
                ans.add(right - left + 1);
            }
            right++;
            if (end >= s.length() - 1) {
                break;
            }
        }
        if (set.size() != 0) {
            ans.add(end - left + 1);
        }
        return ans;
    }
    public List<Integer> partitionLabels0(String s) {
        List<Integer> ans = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int end = 0;
        set.add(s.charAt(0));
        while (end < s.length() - 1) {
            if (set.size() == 0) {
                left = right;
            }
            char ch = s.charAt(right);
            int lastIndex = s.lastIndexOf(ch);
            end = Math.max(end, lastIndex);
            set.add(ch);
            if (right == end) {
                set = new HashSet<>();
                ans.add(right - left + 1);
            }
            right++;
        }
        if (set.size() != 0) {
            ans.add(end - left + 1);
        }
        return ans;
    }
}
