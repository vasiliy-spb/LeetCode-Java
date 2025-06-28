package matrix.workingPeoplesImitation.task_2352_Equal_Row_and_Column_Pairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // my solution
    public int equalPairs(int[][] grid) {
        int countEqualsPair = 0;
        int n = grid.length;
        Map<Integer, int[]> rowMap = new HashMap<>();
        Map<Integer, int[]> columnMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!rowMap.containsKey(i)) {
                    rowMap.put(i, new int[n]);
                }
                rowMap.get(i)[j] = grid[i][j];
                if (!columnMap.containsKey(j)) {
                    columnMap.put(j, new int[n]);
                }
                columnMap.get(j)[i] = grid[i][j];
            }
        }
        for (int[] arr1 : rowMap.values())
            for (int[] arr2 : columnMap.values())
                if (Arrays.equals(arr1, arr2)) {
                    countEqualsPair++;
                }
        return countEqualsPair;
    }

    // from walkccc.me
    public int equalPairs2(int[][] grid) {
        final int n = grid.length;
        int ans = 0;

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                int k = 0;
                for (; k < n; ++k)
                    if (grid[i][k] != grid[k][j])
                        break;
                if (k == n) // R[i] == C[j]
                    ++ans;
            }

        return ans;
    }
}
