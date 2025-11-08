package matrix.workingPeoplesImitation.task_1423_Maximum_Points_You_Can_Obtain_from_Cards;

// my solution
public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];
        for (int i = 0; i < n; i++) {
            prefixSum[i] = cardPoints[i];
            if (i > 0) {
                prefixSum[i] += prefixSum[i - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = cardPoints[i];
            if (i < n - 1) {
                suffixSum[i] += suffixSum[i + 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            int j = n - 1 - (k - 1 - i);
            ans = Math.max(ans, prefixSum[i] + suffixSum[j] - Math.min(cardPoints[i], cardPoints[j]));
        }
        return ans;
    }
}
