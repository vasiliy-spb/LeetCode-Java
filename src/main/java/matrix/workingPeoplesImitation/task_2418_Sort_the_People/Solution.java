package matrix.workingPeoplesImitation.task_2418_Sort_the_People;

import java.util.*;

public class Solution {

    // my solution
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        return map.values().toArray(new String[0]);
    }

    // from walkccc.me
    class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
    public String[] sortPeople2(String[] names, int[] heights) {
        List<Pair<Integer, String>> heightAndNames = new ArrayList<>();

        for (int i = 0; i < names.length; ++i)
            heightAndNames.add(new Pair<>(heights[i], names[i]));

        Collections.sort(heightAndNames, (a, b) -> b.getKey() - a.getKey());

        for (int i = 0; i < heightAndNames.size(); ++i)
            names[i] = heightAndNames.get(i).getValue();

        return names;
    }

    // from leetcode editorial (Approach 1: Map)
    public String[] sortPeople3(String[] names, int[] heights) {
        int numberOfPeople = names.length;

        // Create a map to store height-name pairs
        Map<Integer, String> heightToNameMap = new HashMap<>();

        // Populate the map with height as key and name as value
        for (int i = 0; i < numberOfPeople; i++) {
            heightToNameMap.put(heights[i], names[i]);
        }

        Arrays.sort(heights);

        String[] sortedNames = new String[numberOfPeople];

        // Populate sortedNames array in descending order of height
        for (int i = numberOfPeople - 1; i >= 0; i--) {
            sortedNames[numberOfPeople - i - 1] = heightToNameMap.get(
                    heights[i]
            );
        }

        return sortedNames;
    }

    // from leetcode editorial (Approach 2: Sorted Map)
    public String[] sortPeople4(String[] names, int[] heights) {
        int numberOfPeople = names.length;

        // Create a TreeMap to store height-name pairs (automatically sorted by height)
        TreeMap<Integer, String> heightToNameMap = new TreeMap<>();

        // Populate the map with height as key and name as value
        for (int i = 0; i < numberOfPeople; i++) {
            heightToNameMap.put(heights[i], names[i]);
        }

        String[] sortedNames = new String[numberOfPeople];

        // Index for filling sortedNames array from end to start
        int currentIndex = numberOfPeople - 1;

        // Iterate through the map (sorted by height in ascending order)
        // and fill the sortedNames array from end to start
        for (int height : heightToNameMap.keySet()) {
            sortedNames[currentIndex] = heightToNameMap.get(height);
            currentIndex--;
        }

        return sortedNames;
    }

    // from leetcode editorial (Approach 3: Sort Permutation)
    public String[] sortPeople5(String[] names, int[] heights) {
        int numberOfPeople = names.length;

        // Create an array of indices
        Integer[] sortedIndices = new Integer[numberOfPeople];
        for (int i = 0; i < numberOfPeople; i++) {
            sortedIndices[i] = i;
        }

        // Sort indices based on heights in descending order
        Arrays.sort(sortedIndices, (a, b) -> heights[b] - heights[a]);

        // Apply the sorted indices to rearrange names
        String[] sortedNames = new String[numberOfPeople];
        for (int i = 0; i < numberOfPeople; i++) {
            sortedNames[i] = names[sortedIndices[i]];
        }

        return sortedNames;
    }

    // from leetcode editorial (Approach 4: Quick Sort)
    public String[] sortPeople6(String[] names, int[] heights) {
        quickSort(heights, names, 0, heights.length - 1);
        return names;
    }

    private void swap(int[] heights, String[] names, int index1, int index2) {
        // Swap heights
        int tempHeight = heights[index1];
        heights[index1] = heights[index2];
        heights[index2] = tempHeight;

        // Swap corresponding names
        String tempName = names[index1];
        names[index1] = names[index2];
        names[index2] = tempName;
    }

    private int partition(int[] heights, String[] names, int start, int end) {
        int pivot = heights[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            // If current element is greater than or equal to pivot
            if (heights[j] >= pivot) {
                i++;
                swap(heights, names, i, j);
            }
        }
        // Place the pivot in its correct position
        swap(heights, names, i + 1, end);
        return i + 1;
    }

    private void quickSort(int[] heights, String[] names, int start, int end) {
        if (start < end) {
            // Find the partition index
            int partitionIndex = partition(heights, names, start, end);

            // Recursively sort the left and right sub-arrays
            quickSort(heights, names, start, partitionIndex - 1);
            quickSort(heights, names, partitionIndex + 1, end);
        }
    }

    // from leetcode editorial (Approach 5: Merge Sort)
    public String[] sortPeople7(String[] names, int[] heights) {
        mergeSort(names, heights, 0, heights.length - 1);
        return names;
    }

    private void mergeSort(String[] names, int[] heights, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(names, heights, start, mid);
            mergeSort(names, heights, mid + 1, end);
            merge(names, heights, start, mid, end);
        }
    }

    private void merge(
            String[] names,
            int[] heights,
            int start,
            int mid,
            int end
    ) {
        int leftSize = mid - start + 1;
        int rightSize = end - mid;

        // Create temporary arrays
        int[] leftHeights = new int[leftSize];
        int[] rightHeights = new int[rightSize];
        String[] leftNames = new String[leftSize];
        String[] rightNames = new String[rightSize];

        // Copy data to temporary arrays
        for (int i = 0; i < leftSize; i++) {
            leftHeights[i] = heights[start + i];
            leftNames[i] = names[start + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rightHeights[j] = heights[mid + 1 + j];
            rightNames[j] = names[mid + 1 + j];
        }

        // Merge the temporary arrays
        int leftIndex = 0, rightIndex = 0;
        int mergeIndex = start;
        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftHeights[leftIndex] >= rightHeights[rightIndex]) { // Descending order
                heights[mergeIndex] = leftHeights[leftIndex];
                names[mergeIndex] = leftNames[leftIndex];
                leftIndex++;
            } else {
                heights[mergeIndex] = rightHeights[rightIndex];
                names[mergeIndex] = rightNames[rightIndex];
                rightIndex++;
            }
            mergeIndex++;
        }

        // Copy remaining elements of leftHeights[], if any
        while (leftIndex < leftSize) {
            heights[mergeIndex] = leftHeights[leftIndex];
            names[mergeIndex] = leftNames[leftIndex];
            leftIndex++;
            mergeIndex++;
        }

        // Copy remaining elements of rightHeights[], if any
        while (rightIndex < rightSize) {
            heights[mergeIndex] = rightHeights[rightIndex];
            names[mergeIndex] = rightNames[rightIndex];
            rightIndex++;
            mergeIndex++;
        }
    }

}
