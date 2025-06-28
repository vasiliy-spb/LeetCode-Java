package matrix.workingPeoplesImitation.task_165_Compare_Version_Numbers;

import java.util.Arrays;

public class Solution {

    // my solution
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i1 = 0;
        int i2 = 0;
        while (i1 < arr1.length || i2 < arr2.length) {
            if (i1 < arr1.length && i2 < arr2.length) {
                int a = Integer.parseInt(arr1[i1]);
                int b = Integer.parseInt(arr2[i2]);
                if (a < b) return -1;
                if (a > b) return 1;
                i1++;
                i2++;
            } else if (i1 < arr1.length) {
                int a = Integer.parseInt(arr1[i1]);
                if (a > 0) return 1;
                i1++;
            } else {
                int b = Integer.parseInt(arr2[i2]);
                if (0 < b) return -1;
                i2++;
            }
        }
        return 0;
    }

    // from walkccc.me
    public int compareVersion2(String version1, String version2) {
        final String[] levels1 = version1.split("\\.");
        final String[] levels2 = version2.split("\\.");
        final int length = Math.max(levels1.length, levels2.length);

        for (int i = 0; i < length; ++i) {
            final Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            final Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            final int compare = v1.compareTo(v2);
            if (compare != 0)
                return compare;
        }

        return 0;
    }
}
