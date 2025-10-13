package matrix.workingPeoplesImitation.task_2273_Find_Resultant_Array_After_Removing_Anagrams;

import java.util.*;

// my solution
public class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        int left = 0;
        int right = 1;
        Set<Integer> ignoredIndexes = new HashSet<>();
        while (left < n - 1 && right < n) {
            if (isAnagram(words[left], words[right])) {
                ignoredIndexes.add(right++);
            } else {
                left = right;
                right++;
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!ignoredIndexes.contains(i)) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    private boolean isAnagram(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return new String(chars1).equals(new String(chars2));
    }
}
