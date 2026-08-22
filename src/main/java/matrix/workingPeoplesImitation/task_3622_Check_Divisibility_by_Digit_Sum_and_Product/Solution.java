package matrix.workingPeoplesImitation.task_3622_Check_Divisibility_by_Digit_Sum_and_Product;

// my solution
public class Solution {
    public boolean checkDivisibility(int n) {
        int origin = n;
        int sum = 0;
        int product = 1;
        while (n > 0) {
            sum += n % 10;
            product *= n % 10;
            n /= 10;
        }
        return origin % (sum + product) == 0;
    }
}
