package matrix.workingPeoplesImitation.task_275_H_Index_II;

public class Solution {

    // my solution
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (citations[middle] == citations.length - middle)
                return Math.min(citations.length - middle, citations[middle]);
            if (citations[middle] > citations.length - middle) right = middle;
            else left = middle + 1;
        }
        return Math.min(citations.length - left, citations[left]);
    }

    // from walkccc.me
    public int hIndex2(int[] citations) {
        final int n = citations.length;
        int l = 0;
        int r = n;

        while (l < r) {
            final int m = (l + r) / 2;
            if (citations[m] >= n - m)
                r = m;
            else
                l = m + 1;
        }

        return n - l;
    }

}
