package matrix.workingPeoplesImitation.task_2982_Find_Longest_Special_Substring_That_Occurs_Thrice_II;

// from leetcode solutions (2)
// https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-ii/solutions/4483094/keeping-top-3-lengths-in-a-static-array-o-n-no-vectors-c-71-ms-java-22-ms-beating-100/
public class Solution9 {
    private static final int[] lens = new int[26 * 3];

    public static int maximumLength(final String s) {
        final int n = s.length();
        int start = 0;
        char last = s.charAt(0);
        for (int i = 1; i < n; i++) {
            final char c = s.charAt(i);
            if (c != last) {
                int len = i - start;
                final int b = (last - 'a') * 3;
                if (len > lens[b]) {
                    final int t = lens[b];
                    lens[b] = len;
                    len = t;
                }
                if (len > lens[b + 1]) {
                    final int t = lens[b + 1];
                    lens[b + 1] = len;
                    len = t;
                }
                if (len > lens[b + 2])
                    lens[b + 2] = len;
                start = i;
                last = c;
            }
        }
        {
            int len = n - start;
            final int b = (last - 'a') * 3;
            if (len > lens[b]) {
                final int t = lens[b];
                lens[b] = len;
                len = t;
            }
            if (len > lens[b + 1]) {
                final int t = lens[b + 1];
                lens[b + 1] = len;
                len = t;
            }
            if (len > lens[b + 2])
                lens[b + 2] = len;
        }
        int maxlen = 0;
        for (int j = 0; j < 78; j += 3) {
            if (lens[j] != 0) {
                final int len = lens[j+1] == lens[j]
                        ? lens[j] - (lens[j+2] < lens[j] ? 1 : 0)
                        : lens[j+1] > lens[j] - 2 ? lens[j+1] : lens[j] - 2;
                if (maxlen < len) maxlen = len;
                lens[j] = lens[j+1] = lens[j+2] = 0;
            }
        }
        return maxlen > 0 ? maxlen : -1;
    }
}
