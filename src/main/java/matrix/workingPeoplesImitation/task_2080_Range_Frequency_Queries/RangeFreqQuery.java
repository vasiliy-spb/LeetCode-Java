package matrix.workingPeoplesImitation.task_2080_Range_Frequency_Queries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// my solution
public class RangeFreqQuery {
    private final Map<Integer, List<Integer>> indexMap = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            indexMap.computeIfAbsent(arr[i], list -> new ArrayList<>()).add(i);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> indexes = indexMap.getOrDefault(value, new ArrayList<>());
        if (indexes.isEmpty()) {
            return 0;
        }
        if (indexes.get(indexes.size() - 1) < left || indexes.get(0) > right) {
            return 0;
        }
        int leftIndex = searchLower(indexes, left);
        int rightIndex = searchUpper(indexes, right);
        return rightIndex - leftIndex;
    }

    private int searchLower(List<Integer> indexes, int target) {
        int l = 0;
        int r = indexes.size();
        while (l < r) {
            int middle = (l + r) >> 1;
            if (indexes.get(middle) < target) {
                l = middle + 1;
            } else {
                r = middle;
            }
        }
        return l;
    }

    private int searchUpper(List<Integer> indexes, int target) {
        int l = 0;
        int r = indexes.size();
        while (l < r) {
            int middle = (l + r) >> 1;
            if (indexes.get(middle) <= target) {
                l = middle + 1;
            } else {
                r = middle;
            }
        }
        return l;
    }
}
