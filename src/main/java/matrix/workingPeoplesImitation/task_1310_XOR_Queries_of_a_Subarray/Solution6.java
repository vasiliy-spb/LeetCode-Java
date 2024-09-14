package matrix.workingPeoplesImitation.task_1310_XOR_Queries_of_a_Subarray;

// from AhlawatAbhishek (https://github.com/AhlawatAbhishek/MayurProgrammingClub/blob/main/LeetCode%20solutions/1310.%20XOR%20Queries%20of%20a%20Subarray)
public class Solution6 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int size = arr.length;
        int prefXor[] = new int[size];
        for (int indx = 0; indx < size; indx++) {
            if (indx == 0) prefXor[indx] = arr[indx];
            else prefXor[indx] = prefXor[indx - 1] ^ arr[indx];
        }
        int res[] = new int[queries.length];
        int indx = 0;
        for (var quer : queries) {
            int left = quer[0], right = quer[1];
            res[indx++] = prefXor[right] ^ ((left == 0) ? 0 : prefXor[left - 1]);
        }
        return res;
    }
}
