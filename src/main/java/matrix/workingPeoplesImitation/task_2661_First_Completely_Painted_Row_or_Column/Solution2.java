package matrix.workingPeoplesImitation.task_2661_First_Completely_Painted_Row_or_Column;

import java.util.HashMap;
import java.util.Map;

// my solution 2
public class Solution2 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }
        int minLastIndex = arr.length;
        for (int i = 0; i < mat.length; i++) {
            int lastIndex = 0;
            for (int j = 0; j < mat[i].length; j++) {
                lastIndex = Math.max(lastIndex, indexMap.get(mat[i][j]));
            }
            minLastIndex = Math.min(minLastIndex, lastIndex);
        }
        for (int j = 0; j < mat[0].length; j++) {
            int lastIndex = 0;
            for (int i = 0; i < mat.length; i++) {
                lastIndex = Math.max(lastIndex, indexMap.get(mat[i][j]));
            }
            minLastIndex = Math.min(minLastIndex, lastIndex);
        }
        return minLastIndex;
    }
}
