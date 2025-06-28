package matrix.workingPeoplesImitation.task_440_K_th_Smallest_in_Lexicographical_Order;


public class Solution {
    public int findKthNumber2(int n, int k) {
        long current = 1;
        int start = 0;
        int count = 0;

        /*
        n == 33334
        count 11111 == currentNum 19999
         */

        int step = 1; // 11111

        System.out.println("n = " + n);
        System.out.println("k = " + k);
        int firstDigitInK = k;
        int deepK = 0;
        while (firstDigitInK >= 10) {
            firstDigitInK /= 10;
            deepK++;
        }
        System.out.println("firstDigitInK = " + firstDigitInK);
        System.out.println("deepK = " + deepK);
        System.out.println();

        int firstDigitInN = n;
        int deepN = 0;
        while (firstDigitInN >= 10) {
            firstDigitInN /= 10;
            deepN++;
        }
        System.out.println("firstDigitInN = " + firstDigitInN);
        System.out.println("deepN = " + deepN);

        while (deepN-- > 0) {
            step *= 10;
            step++;
        }

        int startPos = 0;
        int currentNum = 1;
//        if (firstDigitInK > 1) {
//            currentNum = firstDigitInK - 1;
//            startPos = 1;
//            while (deepK-- > 0) {
//                currentNum *= 10;
//                currentNum += 9;
//                startPos *= 10;
//                startPos += 1;
//            }
//            startPos *= firstDigitInN - 1;
////            ans = currentNum;
//            count = startPos;
//        }

        if (step * 2 + startPos < n && step + startPos < k) {
            currentNum = 9;
            int numStep = 1;
            while (deepK-- > 0) {
                currentNum *= 10;
                currentNum += 9;
                numStep *= 10;
            }
            while (step * 2 + startPos < n && step + startPos < k) {
                startPos += step;
                currentNum += numStep;
            }

            System.out.println("step = " + step);
            System.out.println("numStep = " + numStep);
        }

        System.out.println("startPos = " + startPos);
        System.out.println("currentNum = " + currentNum);


//        if (n == 1_000_000_000 && k > n / 2) {
//            current = 549999999;
//            count = start = n / 2;
//        }
//        else if (n > 100_000_000 && k > 100_000_000) {
//            start = count = 340846389;
//            current = 406761747;
//        }
        for (int i = start; i < n; i++) {
//            if (n > 100000000 && k > 100000000 && i == n / 2) {
//                System.out.println("i = " + i);
//                System.out.println("current = " + current);
//                System.out.println("count = " + count);
//            }
//            if (n == 1_000_000_000 && i == n / 2) {
//                System.out.println("i = " + i);
//                System.out.println("current = " + current);
//                System.out.println("count = " + count);
//            }

//            k--;
            if (i == n / 2) {
                System.out.println("n = " + n);
                System.out.println("k = " + k);
                System.out.println("i = " + i);
                System.out.println("start = " + start);
                System.out.println("count = " + count);
                System.out.println("current = " + current);
            }
            count++;
            if (count == k) {
//                System.out.println("17 current = " + current);
                return (int) current;
            }
            if (current * 10 <= n) {
                current *= 10;
            } else {
                while (current % 10 == 9 || current >= n) {
                    current /= 10;
                }
                current++;
            }
        }
        return (int) current;
    }

    public int findKthNumber1(int n, int k) {
        int cnt = 0;
        int current = 1;
        for (int i = 0; i < n; i += 1) {
            cnt += 1;
            if (cnt == k) {
                return current;
            }
            if (current * 10 <= n) {
                current *= 10;
            } else {
                while (current % 10 == 9 || current >= n) {
                    current /= 10;
                }
                current += 1;
            }
        }
        return current;
    }

    int ans = -1;
    int count = 0;

    public int findKthNumber(int n, int k) {
        for (int i = 1; i <= 9; i++) {
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
            generateNumbers(current * 10 + i, n, k);
        }
    }
}
