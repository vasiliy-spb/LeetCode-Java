package matrix.workingPeoplesImitation.task_2981_Find_Longest_Special_Substring_That_Occurs_Thrice_I;

// from leetcode code sample (2)
public class Solution4 {
    private static final int A_CODE = 'a';

    public int maximumLength(String s) {

        byte[][] maxes = new byte[26][4];

        int i = 0;
        int c = s.charAt(i) - A_CODE;
        byte cCount = 1;

        for (i = 1; i < s.length(); i++) {
            int cNext = s.charAt(i) - A_CODE;
            if (c == cNext) {
                cCount++;
            } else {
                addMax(maxes[c], cCount);
                c = cNext;
                cCount = 1;
            }
        }
        addMax(maxes[c], cCount);

        byte max = -1;
        for (int j = 0; j < 26; j++) {

            byte jMax = getMax(maxes[j], max);
            if (jMax > max && jMax > 0) {
                max = jMax;
            }
        }

        return max;
    }

    private byte getMax(byte[] maxes, byte currentMax) {
        if (maxes[0] == 0 || maxes[0] <= currentMax) {
            return -1;
        }

        byte m0 = maxes[0];
        byte m1 = maxes[1];
        byte m2 = maxes[2];
        if (m1 <= m0 - 2) {
            return (byte) (m0 - 2);
        }
        if (m1 == m0 - 1) {
            return m1;
        }
        // m1 == m0
        if (m2 == m0) {
            return m0;
        } else {
            return (byte) (m0 - 1);
        }
    }

    private void addMax(byte[] maxes, byte max) {
        maxes[3] = max;

        for (int i = 3; 0 < i; i--) {
            if (maxes[i] > maxes[i - 1]) {
                byte temp = maxes[i - 1];
                maxes[i - 1] = maxes[i];
                maxes[i] = temp;
            } else {
                break;
            }
        }
    }
}
