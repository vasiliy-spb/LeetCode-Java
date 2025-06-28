package matrix.workingPeoplesImitation.task_440_K_th_Smallest_in_Lexicographical_Order;

public class Solution2 {
    public int findKthNumber(int n, int k) {
        long current = 1;
        int start = 0;
        int count = 0;

        long currentNum = 1;
        int startPos = 0;

        /*
        n == 33334
        count 01112 == currentNum 10999
        count 02223 == currentNum 11999

         */
        int firstDigitInN = n;
        int deepN = 0;
        while (firstDigitInN >= 10) {
            firstDigitInN /= 10;
            deepN++;
        }
        System.out.println("firstDigitInN = " + firstDigitInN);
        System.out.println("deepN = " + deepN);

        if (firstDigitInN > 1) {
            System.out.println("23 СЧИТАЕМ ЗДЕСЬ");
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


            while (deepN-- > 0) {
                step *= 10;
                step++;
            }

//            int startPos = 0;
//            long currentNum = 1;

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
        } else {
//            System.out.println("65 СЧИТАЕМ ЗДЕСЬ");
//            int step = 1;
//
//            System.out.println("n = " + n);
//            System.out.println("k = " + k);
//            int firstDigitInK = k;
//            int deepK = 0;
//            while (firstDigitInK >= 10) {
//                firstDigitInK /= 10;
//                deepK++;
//            }
//            System.out.println("firstDigitInK = " + firstDigitInK);
//            System.out.println("deepK = " + deepK);
//            System.out.println();
//
//
//            int stepLength = deepN - 2;
//            while (stepLength-- > 0) {
//                step *= 10;
////                step += 9;
//            }
//
////            int add = 9;
////            int addLength = deepN - 1;
////            while (addLength-- > 0) {
////                add *= 10;
////                add += 9;
////            }
////            step += add;
//
//            System.out.println("96 step = " + step);
//
//            if (step * 2 + startPos < n && step + startPos < k) {
//                currentNum = 9;
//                int numStep = 1;
//                while (deepK-- > 0) {
//                    currentNum *= 10;
//                    currentNum += 9;
//                    numStep *= 10;
//                }
//                while (step * 2 + startPos < n && step + startPos < k) {
//                    startPos += step;
//                    currentNum += numStep;
//                }
//
//                System.out.println("step = " + step);
//                System.out.println("numStep = " + numStep);
//            }
//            System.out.println("startPos = " + startPos);
//            System.out.println("currentNum = " + currentNum);
        }

        current = currentNum;
        start = count = startPos;

        for (int i = start; i < n; i++) {
            count++;
            if (count == k) {
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
}
