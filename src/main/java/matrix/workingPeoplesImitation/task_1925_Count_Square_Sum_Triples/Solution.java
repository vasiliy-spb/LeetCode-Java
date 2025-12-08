package matrix.workingPeoplesImitation.task_1925_Count_Square_Sum_Triples;

// my solution
public class Solution {
    public int countTriples(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int squareI = i * i;
            for (int j = 1; j <= n; j++) {
                int squareJ = j * j;
                if (squareJ >= squareI) {
                    break;
                }
                for (int k = 1; k <= n; k++) {
                    int squareK = k * k;
                    if (squareK + squareJ > squareI) {
                        break;
                    }
                    if (squareK + squareJ == squareI) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
