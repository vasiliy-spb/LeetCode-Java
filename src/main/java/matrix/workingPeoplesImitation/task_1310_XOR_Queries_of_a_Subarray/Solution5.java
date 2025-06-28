package matrix.workingPeoplesImitation.task_1310_XOR_Queries_of_a_Subarray;

import java.util.Arrays;

// from leetcode comment to editorial (by NirmalGurjar)
public class Solution5 {
    int xor = 0;
    int[] prefixArr = null;

    public int[] xorQueries(int[] arr, int[][] queries) {
        prefixArr = Arrays.stream(arr).map(a -> xor ^= a).toArray();
        return Arrays.stream(queries).mapToInt(a -> (a[0] == 0 ? 0 : prefixArr[a[0] - 1]) ^ prefixArr[a[1]]).toArray();
    }
}
