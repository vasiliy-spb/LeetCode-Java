package matrix.workingPeoplesImitation.task_1318_Minimum_Flips_to_Make_a_OR_b_Equal_to_c;

public class Solution {
    public int minFlips(int a, int b, int c) {
//        System.out.println("a = " + Integer.toBinaryString(a));
//        System.out.println("b = " + Integer.toBinaryString(b));
//        System.out.println("c = " + Integer.toBinaryString(c));
//        System.out.println();

        int num = 1;
        int count = 0;
        int bitPosition = 0;
        while (num <= Math.max(c, Math.max(a, b))) {
//            System.out.println("num = " + Integer.toBinaryString(num));
            num <<= 1;
            int bitA = (a >> bitPosition) & 1;
            int bitB = (b >> bitPosition) & 1;
            int bitC = (c >> bitPosition) & 1;
//            System.out.println("bitA = " + bitA);
//            System.out.println("bitB = " + bitB);
//            System.out.println("bitC = " + bitC);

            if (bitC == 1) {
                if (bitA == 0 && bitB == 0) count++;
            } else {
                if (bitA == 1) count++;
                if (bitB == 1) count++;
            }
            bitPosition++;

//            System.out.println("count = " + count);
//            System.out.println();
        }
        return count;
    }

    // from walkccc.me
    public int minFlips2(int a, int b, int c) {
        final int kMaxBit = 30;
        int ans = 0;

        for (int i = 0; i < kMaxBit; ++i)
            if ((c >> i & 1) == 1)
                ans += ((a >> i & 1) == 0 && (b >> i & 1) == 0) ? 1 : 0;
            else // (c >> i & 1) == 0
                ans += ((a >> i & 1) == 1 ? 1 : 0) + ((b >> i & 1) == 1 ? 1 : 0);

        return ans;
    }
}
