package matrix.workingPeoplesImitation.task_1128_Number_of_Equivalent_Domino_Pairs;

// from leetcode code sample (1)
public class Solution4 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] dp = new int[10][10];
        for (int[] domino : dominoes) {
            dp[domino[0]][domino[1]]++;
        }
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i; j < dp[i].length; j++) {
                int count = dp[i][j];
                if (i != j) {
                    count += dp[j][i];
                }
                max += count * (count - 1) / 2;
            }
        }
        return max;
    }
}

//      0   1   2   3   4   5   6   7   8   9

// 0    0   0   0   0   0   0   0   0   0   0

// 1    0   1   3   0   0   0   0   0   0   0

// 2    0   0   1   0   0   0   0   0   0   0

// 3    0   0   0   0   0   0   0   0   0   0

// 4    0   0   0   0   0   0   0   0   0   0

// 5    0   0   0   0   0   0   0   0   0   0

// 6    0   0   0   0   0   0   0   0   0   0

// 7    0   0   0   0   0   0   0   0   0   0

// 8    0   0   0   0   0   0   0   0   0   0

// 9    0   0   0   0   0   0   0   0   0   0
