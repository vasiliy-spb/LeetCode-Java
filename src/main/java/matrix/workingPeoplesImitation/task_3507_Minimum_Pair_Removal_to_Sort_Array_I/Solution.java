package matrix.workingPeoplesImitation.task_3507_Minimum_Pair_Removal_to_Sort_Array_I;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// my solution 1
public class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        int count = 0;
        while (!isSorted(list)) {
            mergeMinSum(list);
            count++;
        }
        return count;
    }

    private void mergeMinSum(List<Integer> list) {
        int indexMinSum = findIndexMinSum(list);
        int sum = list.get(indexMinSum) + list.get(indexMinSum + 1);
        list.set(indexMinSum, sum);
        list.remove(indexMinSum + 1);
    }

    private int findIndexMinSum(List<Integer> list) {
        int minSum = Integer.MAX_VALUE;
        int index = -1;
        int size = list.size();
        for (int i = 1; i < size; i++) {
            int currentSum = list.get(i) + list.get(i - 1);
            if (currentSum < minSum) {
                minSum = currentSum;
                index = i - 1;
            }
        }
        return index;
    }

    private boolean isSorted(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        int prev = iterator.next();
        while (iterator.hasNext()) {
            int current = iterator.next();
            if (current < prev) {
                return false;
            }
            prev = current;
        }
        return true;
    }
}
