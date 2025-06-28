package matrix.workingPeoplesImitation.task_274_H_Index;

import java.util.Arrays;

public class Solution {

    // my solution (без разворота массива)
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int result = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] >= citations.length - i) result = citations.length - i;
            else break;
        }
        return Math.min(result, citations.length);
    }

    // my solution (с разворотом массива)
    public int hIndex1(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = citations[i];
            citations[i] = citations[n - i - 1];
            citations[n - i - 1] = temp;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 <= citations[i]) result = i + 1;
        }
        return Math.min(result, citations.length);
    }

    // from walkccc.me (Approach 2: Sort)
    public int hIndex2(int[] citations) {
        final int n = citations.length;

        Arrays.sort(citations);

        for (int i = 0; i < n; ++i)
            if (citations[i] >= n - i)
                return n - i;

        return 0;
    }

    // from walkccc.me (Approach 1: Bucket)
    public int hIndex3(int[] citations) {
        final int n = citations.length;
        int accumulate = 0;
        int[] count = new int[n + 1];

        for (final int citation : citations)
            ++count[Math.min(citation, n)];

        // To find the maximum h-index, loop from the back to the front.
        // i := the candidate's h-index
        for (int i = n; i >= 0; --i) {
            accumulate += count[i];
            if (accumulate >= i)
                return i;
        }

        throw new IllegalArgumentException();
    }
}
