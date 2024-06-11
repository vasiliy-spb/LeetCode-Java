package matrix.workingPeoplesImitation.task_1122_Relative_Sort_Array;

import java.util.TreeMap;

public class Solution {

    // my solution
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.merge(arr1[i], 1, Integer::sum);
        }
        int index = 0;
        for (int num : arr2) {
            int count = map.get(num);
            while (count > 0) {
                arr1[index++] = num;
                count--;
            }
            map.remove(num);
        }
        for (int key : map.keySet()) {
            int count = map.get(key);
            while (count > 0) {
                arr1[index++] = key;
                count--;
            }
        }
        return arr1;
    }

    // from walkccc.me
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int[] count = new int[1001];
        int i = 0;

        for (int a : arr1)
            ++count[a];

        for (int a : arr2)
            while (count[a]-- > 0)
                ans[i++] = a;

        for (int num = 0; num < 1001; ++num)
            while (count[num]-- > 0)
                ans[i++] = num;

        return ans;
    }

}
