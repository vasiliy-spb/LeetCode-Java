package matrix.workingPeoplesImitation.task_1394_Find_Lucky_Integer_in_an_Array;

// from leetcode code sample (1)
public class Solution3 {
    public static int findLucky(int[] arr) {
        if (arr.length == 0) return -1;

        int[] obeme = new int[501];

        for (int el : arr) {
            obeme[el] += 1;
        }

        for (int i = 500; i > 0; i--) {
            if (i == obeme[i]) return i;
        }

        return -1;
    }
}
