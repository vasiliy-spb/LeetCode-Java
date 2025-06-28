package matrix.workingPeoplesImitation.task_703_Kth_Largest_Element_in_a_Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// from leetcode editorial (Approach 1: Maintain Sorted List)
class KthLargest2 {

    List<Integer> stream;
    int k;

    public KthLargest2(int k, int[] nums) {
        stream = new ArrayList<Integer>(nums.length);
        this.k = k;

        for (int num : nums) {
            stream.add(num);
        }

        Collections.sort(stream);
    }

    public int add(int val) {
        int index = getIndex(val);
        // Add val to correct position
        stream.add(index, val);
        return stream.get(stream.size() - k);
    }

    private int getIndex(int val) {
        int left = 0;
        int right = stream.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midElement = stream.get(mid);
            if (midElement == val) return mid;
            if (midElement > val) {
                // Go to left half
                right = mid - 1;
            } else {
                // Go to right half
                left = mid + 1;
            }
        }
        return left;
    }
}
