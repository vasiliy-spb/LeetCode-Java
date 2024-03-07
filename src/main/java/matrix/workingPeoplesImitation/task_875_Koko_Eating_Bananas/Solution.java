package matrix.workingPeoplesImitation.task_875_Koko_Eating_Bananas;

import java.util.Arrays;

public class Solution {

    // my solution
    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 1) return piles[0] / h + (piles[0] % h == 0 ? 0 : 1);
        Arrays.sort(piles);

//        System.out.println("piles = " + Arrays.toString(piles));

        int l = 1;
        int r = 1_000_000_001;
        while (l < r) {
            int k = (l + r) / 2;
            int res = calculateEatingSpeed(piles, h, k);
//            System.out.println("l = " + l);
//            System.out.println("r = " + r);
//            System.out.println("k = " + k);
//            System.out.println("res = " + res);
//            System.out.println();

            if (res < 0) {
                l = k + 1;
            } else {
                r = k;
            }
        }
//        System.out.println("l = " + l);
        return l;
    }

    private int calculateEatingSpeed(int[] piles, int h, int k) {
//        System.out.println("— calculateEatingSpeed —");
//        System.out.println("k = " + k);
        for (int i = piles.length - 1; i >= 0; i--) {
//            System.out.println("piles[i] = " + piles[i]);
//            System.out.println("h = " + h);
            if (piles[i] <= k) {
//                System.out.println(piles[i] <= k);
                h -= i + 1;
                break;
            }
            h -= piles[i] / k;
            if (piles[i] % k != 0) h--;
            if (h < 0) break;
        }
//        System.out.println("h = " + h);
//        System.out.println();
        return h;
    }
}
