package matrix.workingPeoplesImitation.task_440_K_th_Smallest_in_Lexicographical_Order;

public class Solution5 {
    public int findKthNumber(int n, int k) {
//        System.out.println("n = " + n);
//        System.out.println("k = " + k);
        int count = 1;
        long current = 1;
        while (count < k) {
            count++;
            if (current * 10 <= n) {
                current *= 10;
            } else {
                while (current % 10 == 9 || current == n) {
                    current /= 10;
                }
                current++;
            }
            if (current == 2) {
//                int add = count - 1;
//                while ((add % 100) % 11 != 0) {
//                    add--;
//                }
                int a = 1;
                while (a < count) {
                    a *= 10;
                    a++;
                }
                a--;
                System.out.println("a = " + a);
                while (count + a < k) {
                    count += a;
                    current++;
                }
            }
        }
        return (int) current;
    }

    private int getFirstDigit(int n) {
        while (n >= 10) {
            n /= 10;
        }
        return n;
    }
}
