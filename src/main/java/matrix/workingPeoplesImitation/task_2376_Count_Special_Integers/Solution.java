package matrix.workingPeoplesImitation.task_2376_Count_Special_Integers;

// my solution
public class Solution {
    public int countSpecialNumbers(int n) {
        long count = 0;
        int mask = 0;
        count += calculateCountSpecialIntegers(0, 1, n, mask);
        return (int) count;
    }

    private long calculateCountSpecialIntegers(long current, long next, int n, int mask) {
        int count = 0;
        if (current > 0) {
            count++;
        }
        for (int i = 0; i <= 9; i++) {
            if (current == i) {
                continue;
            }
            if (current * 10 + i <= n) {
                if ((mask & (1 << i)) == 0) {
                    count += calculateCountSpecialIntegers(current * 10 + i, next * 10, n, (mask | (1 << i)));
                }
            } else {
                break;
            }
        }
        return count;
    }
}
