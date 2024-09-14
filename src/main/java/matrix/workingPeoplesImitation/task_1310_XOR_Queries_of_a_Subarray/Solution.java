package matrix.workingPeoplesImitation.task_1310_XOR_Queries_of_a_Subarray;

// my solution
public class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefixXOR =  new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = prefixXOR[left] ^ prefixXOR[right] ^ arr[right];
        }
        return ans;
    }
}
