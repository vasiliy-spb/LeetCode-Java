package matrix.workingPeoplesImitation.task_1423_Maximum_Points_You_Can_Obtain_from_Cards;

// my solution
public class Solution2 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int currentSum = 0;
        for (int i = n - k; i < n; i++) {
            currentSum += cardPoints[i];
        }
        int ans = currentSum;
        for (int i = 0; i < k; i++) {
            currentSum -= cardPoints[n - k + i];
            currentSum += cardPoints[i];
            ans = Math.max(ans, currentSum);
        }
        return ans;
    }
}
