package matrix.workingPeoplesImitation.task_2485_Find_the_Pivot_Integer;

public class Solution {
    public int pivotInteger(int n) {
        int left = 1;
        int right = n;
        int sumLeft = 1;
        int sumRight = n;
        while (left <= right) {
            if (left == right && sumLeft == sumRight) return left;
            if (sumLeft < sumRight) {
                left++;
                sumLeft += left;
            } else {
                right--;
                sumRight += right;
            }
        }
        return -1;
    }
}
