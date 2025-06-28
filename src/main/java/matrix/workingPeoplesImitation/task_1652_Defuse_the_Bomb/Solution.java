package matrix.workingPeoplesImitation.task_1652_Defuse_the_Bomb;

// my solution
public class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            return new int[n];
        }
        if (k > 0) {
            return getNextSumArray(code, n, k);
        }
        return getPrevSumArray(code, n, k);
    }

    private int[] getPrevSumArray(int[] code, int n, int k) {
        int[] prevSum = new int[n];
        int sum = 0;
        int right = n + k;
        while (right < n) {
            sum += code[right++];
        }
        for (int i = 0; i < n; i++) {
            prevSum[i] = sum;
            sum -= code[(n + i + k) % n];
            sum += code[i];
        }
        return prevSum;
    }

    private int[] getNextSumArray(int[] code, int n, int k) {
        int[] nextSum = new int[n];
        int sum = 0;
        int right = 0;
        while (right < k) {
            sum += code[right++];
        }
        for (int i = 0; i < n; i++) {
            sum += code[right % n];
            sum -= code[(right - k + n) % n];
            right++;
            nextSum[i] = sum;
        }
        return nextSum;
    }
}
