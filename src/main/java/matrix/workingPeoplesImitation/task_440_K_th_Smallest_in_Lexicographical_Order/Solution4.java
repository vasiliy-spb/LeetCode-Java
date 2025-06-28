package matrix.workingPeoplesImitation.task_440_K_th_Smallest_in_Lexicographical_Order;

public class Solution4 {
    int ans = -1;
    long count = 0;

    public int findKthNumber(int n, int k) {
        System.out.println("n = " + n);
        System.out.println("k = " + k);
        System.out.println();
        generateNumbers(1, n, k);
        if (ans > 0) {
            return ans;
        }
        long countForOneDigit = count;
        count = 0;
        int start = 1;
        if (count + countForOneDigit < k) {
            count += countForOneDigit;
            start++;
        }

        System.out.println("countForOneDigit = " + countForOneDigit);
        System.out.println("count = " + count);
        System.out.println("start = " + start);

        for (int i = start; i <= 9; i++) {
            if (ans > 0) {
                break;
            }
            generateNumbers(i, n, k);
        }
        return ans;
    }

    private void generateNumbers(long current, int n, int k) {
        if (count > k) {
            return;
        }
        if (current > n) {
            return;
        }
        count++;
        if (count == k) {
            ans = (int) current;
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (count >= k) {
                break;
            }
            if (current * 10 + i > n) {
                break;
            }
            if (i == 0) {
                long prevCount = count;
                generateNumbers(current * 10 + i, n, k);
                long diffCount = prevCount - count;
                count = prevCount;
                while (i <= 9 && count + diffCount < k) {
                    count += diffCount;
                    i++;
                    if (current * 10 + i > n) {
                        break;
                    }
                }
                if (i >= 9) {
                    continue;
                }
            }
            generateNumbers(current * 10 + i, n, k);
        }
    }
}
