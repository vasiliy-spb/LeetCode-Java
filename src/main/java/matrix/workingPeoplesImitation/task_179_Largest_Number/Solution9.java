package matrix.workingPeoplesImitation.task_179_Largest_Number;

import java.util.Arrays;
import java.util.Comparator;

// from leetcode code sample (1)
public class Solution9 {
    public String largestNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                long na = 10;
                long nb = 10;
                while (na <= a) {
                    na *= 10;
                }
                while (nb <= b) {
                    nb *= 10;
                }
                long ab = a * nb + b;
                long ba = b * na + a;
                return ba > ab ? 1 : -1;
            }
        });
        if (arr[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : arr) {
            sb.append(i);
        }
        return sb.toString();
    }
}
