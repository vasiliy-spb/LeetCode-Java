package matrix.workingPeoplesImitation.task_2614_Prime_In_Diagonal;

// my solution
public class Solution {
    public int diagonalPrime(int[][] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][i] > ans && isPrime(nums[i][i])) {
                ans = nums[i][i];
            }
            if (nums[i][n - 1 - i] > ans && isPrime(nums[i][n - 1 - i])) {
                ans = nums[i][n - 1 - i];
            }
        }
        return ans > 1 ? ans : 0;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
