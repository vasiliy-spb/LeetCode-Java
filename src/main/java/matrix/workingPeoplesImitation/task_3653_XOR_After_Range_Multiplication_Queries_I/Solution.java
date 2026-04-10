package matrix.workingPeoplesImitation.task_3653_XOR_After_Range_Multiplication_Queries_I;

// my solution
class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long[] numbers = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = nums[i];
        }
        int modulo = 1_000_000_007;
        for (int[] query : queries) {
            int idx = query[0];
            while (idx <= query[1]) {
                numbers[idx] = (numbers[idx] * query[3]) % modulo;
                idx += query[2];
            }
        }

        long ans = 0;
        for (long num : numbers) {
            ans ^= num;
        }
        return (int) ans;
    }
}
