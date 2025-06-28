package matrix.workingPeoplesImitation.task_978_Longest_Turbulent_Subarray;

// my solution
public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        boolean prevMore = arr[1] > arr[0];
        boolean prevLess = arr[1] < arr[0];
        int currentLength = 1;
        int maxLength = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                if (prevLess) {
                    currentLength++;
                } else {
                    currentLength = 2;
                }
            } else if (arr[i] < arr[i - 1]) {
                if (prevMore) {
                    currentLength++;
                } else {
                    currentLength = 2;
                }
            } else {
                currentLength = 1;
            }
            prevMore = arr[i] > arr[i - 1];
            prevLess = arr[i] < arr[i - 1];
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }


    public int maxTurbulenceSize0(int[] arr) {
        int[] res = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) res[i - 1] = 1;
            else res[i - 1] = -1;
        }
        int count = 0;
        int current = 0;
        for (int i = 1; i < res.length; i++) {
            if (res[i] != res[i - 1]) {
                current++;
                count = Math.max(count, 2);
                count = Math.max(count, current);
            } else {
//                if (res[i] == res[i - 1]) count = Math.max(count, 1);
//                else count = Math.max(count, 2);
                count = Math.max(count, 1);
                current = 0;
            }
        }
        return count + 1;
    }
}
