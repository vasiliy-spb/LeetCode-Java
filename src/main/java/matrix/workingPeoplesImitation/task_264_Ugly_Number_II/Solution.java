package matrix.workingPeoplesImitation.task_264_Ugly_Number_II;

import java.util.*;

public class Solution {

    // my solution
    public int nthUglyNumber(int n) {
        Set<Long> set = new HashSet<>();
        set.add(1l);
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.offer(1l);
        long uglyNumber = 1;
        while (n-- > 0) {
            uglyNumber = queue.poll();
            if (!set.contains(uglyNumber * 2)) {
                queue.offer(uglyNumber * 2);
                set.add(uglyNumber * 2);
            }
            if (!set.contains(uglyNumber * 3)) {
                queue.offer(uglyNumber * 3);
                set.add(uglyNumber * 3);
            }
            if (!set.contains(uglyNumber * 5)) {
                queue.offer(uglyNumber * 5);
                set.add(uglyNumber * 5);
            }
        }
        return (int) uglyNumber;
    }

    // from walkccc.me
    public int nthUglyNumber2(int n) {
        List<Integer> uglyNums = new ArrayList<>();
        uglyNums.add(1);
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        while (uglyNums.size() < n) {
            final int next2 = uglyNums.get(i2) * 2;
            final int next3 = uglyNums.get(i3) * 3;
            final int next5 = uglyNums.get(i5) * 5;
            final int next = Math.min(next2, Math.min(next3, next5));
            if (next == next2)
                ++i2;
            if (next == next3)
                ++i3;
            if (next == next5)
                ++i5;
            uglyNums.add(next);
        }

        return uglyNums.get(uglyNums.size() - 1);
    }

    // from GPT
    public int nthUglyNumber3(int n) {
        if (n <= 0) {
            return 0; // Invalid input
        }

        // Use a priority queue (min heap) to keep track of the next ugly numbers
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        minHeap.offer(1L); // Start with the first ugly number (1)

        // Set to store already generated ugly numbers to avoid duplicates
        HashSet<Long> generatedUglyNumbers = new HashSet<>();
        generatedUglyNumbers.add(1L);

        // Generate the nth ugly number
        long uglyNumber = 0;
        for (int i = 0; i < n; i++) {
            uglyNumber = minHeap.poll(); // Retrieve the smallest ugly number from the heap

            // Generate and add multiples of the retrieved ugly number
            for (int factor : new int[]{2, 3, 5}) {
                long nextUgly = uglyNumber * factor;
                if (!generatedUglyNumbers.contains(nextUgly)) {
                    minHeap.offer(nextUgly);
                    generatedUglyNumbers.add(nextUgly);
                }
            }
        }

        return (int) uglyNumber;
    }

}
