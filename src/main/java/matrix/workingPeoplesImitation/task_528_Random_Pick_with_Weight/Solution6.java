package matrix.workingPeoplesImitation.task_528_Random_Pick_with_Weight;

import java.util.Random;

// from leetcode code sample (4)
public class Solution6 {
    int[] arr;
    Random rand = new Random();

    public Solution6(int[] w) {
        arr = new int[w.length];
        arr[0] = w[0];

        for (int i = 1; i < w.length; i++) {
            arr[i] = arr[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int target = rand.nextInt(arr[arr.length - 1]);

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
