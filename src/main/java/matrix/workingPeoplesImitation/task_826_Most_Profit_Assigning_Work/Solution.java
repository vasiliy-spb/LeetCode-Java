package matrix.workingPeoplesImitation.task_826_Most_Profit_Assigning_Work;

import java.util.Arrays;

// my solution
public class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, (j1, j2) -> j1.getDifficulty() - j2.getDifficulty());
        Arrays.sort(worker);

        int totalProfit = 0;
        int currentMaxProfit = 0;
        int jIndex = 0;
        int wIndex = 0;
        while (wIndex < worker.length) {
            if (jIndex < n && jobs[jIndex].getDifficulty() <= worker[wIndex]) {
                currentMaxProfit = Math.max(currentMaxProfit, jobs[jIndex].getProfit());
                jIndex++;
            } else {
                totalProfit += currentMaxProfit;
                wIndex++;
            }
        }
        return totalProfit;
    }

    static class Job {
        private final int difficulty;
        private final int profit;

        public Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }

        public int getDifficulty() {
            return difficulty;
        }

        public int getProfit() {
            return profit;
        }
    }
}
