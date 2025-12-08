package matrix.workingPeoplesImitation.task_1925_Count_Square_Sum_Triples;

// from leetcode code sample (2)
public class Solution4 {
    public int countTriples(int n) {
        int result = 0;
        boolean[] isSquare = new boolean[n * n + 1];
        for (int i = 1; i <= n; i++) {
            isSquare[i * i] = true;
        }

        for (int a = 1; a <= n; a++) {
            for (int b = a + 1; b <= n; b++) {
                int sumOfSq = (a * a) + (b * b);
                if (sumOfSq > n * n) {
                    break;
                }
                if (isSquare[sumOfSq]) {
                    result += 2;
                }
            }
        }
        return result;
    }
}
