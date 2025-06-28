package matrix.workingPeoplesImitation.task_763_Partition_Labels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// from leetcode code sample
public class Solution4 {
    public List<Integer> partitionLabels(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int[] lastIndexes = new int[26];
        Arrays.fill(lastIndexes, -1);
        for(int i = 0; i < len; i++) {
            lastIndexes[arr[i] - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        helper(lastIndexes, arr, 0, result);
        return result;
    }
    void helper(int[] idxes, char[] arr, int idx, List<Integer> result) {
        if(idx == arr.length) return;

        int end = idxes[arr[idx] - 'a'];
        int i = idx;
        while(i < arr.length && i < end) {
            int cur = arr[i] - 'a';
            end = Math.max(end, idxes[cur]);
            i++;
        }
        result.add(end - idx + 1);
        helper(idxes, arr, end + 1, result);
    }
}
