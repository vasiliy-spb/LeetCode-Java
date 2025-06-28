package matrix.workingPeoplesImitation.task_1310_XOR_Queries_of_a_Subarray;

// from walkccc.me
public class Solution4 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] xors = new int[arr.length + 1];

        for (int i = 0; i < arr.length; ++i)
            xors[i + 1] = xors[i] ^ arr[i];

        int i = 0;
        for (int[] query : queries) {
            final int left = query[0];
            final int right = query[1];
            ans[i++] = xors[left] ^ xors[right + 1];
        }

        return ans;
    }
}
