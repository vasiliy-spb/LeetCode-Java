package matrix.workingPeoplesImitation.task_179_Largest_Number;

import java.util.Comparator;
import java.util.PriorityQueue;

// from leetcode editorial (Approach 4: HeapSort)
public class Solution7 {
    public String largestNumber(int[] nums) {
        // Priority queue to order numbers using the custom comparison function
        PriorityQueue<String> maxHeap = new PriorityQueue<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String first, String second) {
                        return (second + first).compareTo(first + second);
                    }
                }
        );

        int totalLength = 0;

        // Convert integers to strings and push them into the priority queue
        for (int num : nums) {
            String strNum = Integer.toString(num);
            totalLength += strNum.length();
            maxHeap.offer(strNum);
        }

        // Build the result string from the priority queue
        StringBuilder result = new StringBuilder(totalLength);
        while (!maxHeap.isEmpty()) {
            result.append(maxHeap.poll());
        }

        // Handle edge case where the result might be "000...0"
        return result.charAt(0) == '0' ? "0" : result.toString();
    }
}
