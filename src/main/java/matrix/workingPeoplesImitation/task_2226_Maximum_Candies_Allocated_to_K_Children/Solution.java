package matrix.workingPeoplesImitation.task_2226_Maximum_Candies_Allocated_to_K_Children;

import java.util.Arrays;

// my solution
public class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = Arrays.stream(candies).max().getAsInt();
        int min = 1;
        while (min <= max) {
            int middle = (min + max) >> 1;
            if (isPossible(middle, candies, k)) {
                min = middle + 1;
            } else {
                max = middle - 1;
            }
        }
        return max;
    }

    private boolean isPossible(int candyPerPerson, int[] candies, long k) {
        for (int candy : candies) {
            k -= candy / candyPerPerson;
        }
        return k <= 0;
    }
}
