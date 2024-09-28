package matrix.workingPeoplesImitation.task_214_Shortest_Palindrome;

// from leetcode code sample (3)
public class Solution10 {
    public String shortestPalindrome(String s) {
        char[] chrs = s.toCharArray();
        String sReverse = new StringBuilder(s).reverse().toString();
        char[] chrsReverse = sReverse.toCharArray();
        int[] Z = getZ(chrs);
        int l = -1;
        int r = -1;
        for (int i = 0; i < chrsReverse.length; i++) {
            int len = i < r ? Math.min(Z[i - l], r - i) : 0;
            while (i + len < chrsReverse.length && chrsReverse[i + len] == chrs[len]) {
                len++;
            }
            if (i + len > r) {
                r = i + len;
                l = i;
            }
            if (2 * len >= chrsReverse.length - i)
                return new StringBuilder(sReverse.substring(0, i)).append(s).toString();
        }
        return s;
    }

    public int[] getZ(char[] chrs) {
        int[] Z = new int[chrs.length];
        int l = -1;
        int r = -1;
        for (int i = 1; i < chrs.length; i++) {
            if (i < r) {
                int len = Math.min(Z[i - l], r - i);
                while (i + len < chrs.length && chrs[i + len] == chrs[len]) {
                    len++;
                }
                Z[i] = len;
                if (i + len > r) {
                    r = i + len;
                    l = i;
                }
            } else {
                int len = 0;
                while (i + len < chrs.length && chrs[i + len] == chrs[len]) {
                    len++;
                }
                Z[i] = len;
                if (i + len > r) {
                    r = i + len;
                    l = i;
                }
            }
        }
        return Z;
    }
}
