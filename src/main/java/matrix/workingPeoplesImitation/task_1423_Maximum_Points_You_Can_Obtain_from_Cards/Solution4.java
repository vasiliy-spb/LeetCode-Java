package matrix.workingPeoplesImitation.task_1423_Maximum_Points_You_Can_Obtain_from_Cards;

// from leetcode code sample (1)
public class Solution4 {
    public static int maxScore(int[] cp, int k) {
        if (k > cp.length) {
            return 0;
        }

        int max = 0;
        int sum = 0;
        int r1 = 0;
        int r2 = cp.length - 1;

        while (r1 < k) {
            sum += cp[r1];
            max = Math.max(max, sum);

            r1++;
        }

        if (k == cp.length) {
            return max;
        }

        r1--;

        while (r1 >= 0) {
            sum -= cp[r1];
            sum += cp[r2];

            r1--;
            r2--;

            max = Math.max(max, sum);
        }

        return max;
    }
}
