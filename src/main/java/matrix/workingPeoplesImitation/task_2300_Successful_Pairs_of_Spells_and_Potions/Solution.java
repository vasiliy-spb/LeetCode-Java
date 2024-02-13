package matrix.workingPeoplesImitation.task_2300_Successful_Pairs_of_Spells_and_Potions;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    // my solution (binary search)
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] answer = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            answer[i] = potions.length - firstIndexOfSuccess(spells[i], potions, success);
        }
        return answer;
    }

    private int firstIndexOfSuccess(int spell, int[] potions, long success) {
        int l = 0;
        int r = potions.length;
        while (l < r) {
            int m = (l + r) / 2;
            if ((long) potions[m] * spell < success) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    // my solutoin
    public int[] successfulPairs0(int[] spells, int[] potions, long success) {
        Integer[] indices = new Integer[spells.length];
        for (int i = 0; i < indices.length; i++)
            indices[i] = i;
        Arrays.sort(indices, Comparator.comparingInt(index -> spells[index]));

        Arrays.sort(spells);
        Arrays.sort(potions);
        int[] answer = new int[spells.length];
        for (int i = spells.length - 1, index = 0; i >= 0; i--) {
            while (index < potions.length && (long) potions[index] * spells[i] < success)
                index++;
            answer[indices[i]] = potions.length - index;
        }
        return answer;
    }

    // from walkccc.me
    public int[] successfulPairs2(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; ++i)
            ans[i] = potions.length - firstIndexSuccess(spells[i], potions, success);

        return ans;
    }

    // Returns the first index i s.t. spell * potions[i] >= success.
    private int firstIndexSuccess(int spell, int[] potions, long success) {
        int l = 0;
        int r = potions.length;
        while (l < r) {
            final int m = (l + r) / 2;
            if ((long) spell * potions[m] >= success)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    // from GPT
    public static int[] successfulPairs3(int[] spells, int[] potions, int success) {
        Arrays.sort(potions);

        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            long spellStrength = (long) spells[i];
            int index = binarySearch(potions, success / spellStrength);

            result[i] = potions.length - index;
        }

        return result;
    }

    private static int binarySearch(int[] potions, long target) {
        int left = 0, right = potions.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (potions[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result + 1; // Adding 1 to get the count of elements greater than or equal to target
    }
}
