package matrix.workingPeoplesImitation.task_1630_Arithmetic_Subarrays;

import java.util.*;

public class Solution {

    // my solution
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = l[i]; j <= r[i]; j++) {
                list.add(nums[j]);
            }
            ans.add(isArithmeticSequence(list));
        }
        return ans;
    }
    private boolean isArithmeticSequence(List<Integer> list) {
        Collections.sort(list);
        int diff = -1;
        int prev = Integer.MAX_VALUE;
        for (int num : list) {
            if (prev != Integer.MAX_VALUE) {
                if (diff != -1) {
                    if (Math.abs(num - prev) != diff) {
                        return false;
                    }
                } else {
                    diff = Math.abs(num - prev);
                }
            }
            prev = num;
        }
        return true;
    }

    // from leetcode editorial (Approach 1: Sort and Check)
    public Boolean check(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }

    public List<Boolean> checkArithmeticSubarrays2(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList();
        for (int i = 0; i < l.length; i++) {
            int[] arr = new int[r[i] - l[i] + 1];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nums[l[i] + j];
            }

            ans.add(check(arr));
        }

        return ans;
    }

    // from leetcode editorial (Approach 2: No Sorting)
    public Boolean check2(int[] arr) {
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;
        Set<Integer> arrSet = new HashSet();

        for (int num : arr) {
            minElement = Math.min(minElement, num);
            maxElement = Math.max(maxElement, num);
            arrSet.add(num);
        }

        if ((maxElement - minElement) % (arr.length - 1) != 0) {
            return false;
        }

        int diff = (maxElement - minElement) / (arr.length - 1);
        int curr = minElement + diff;

        while (curr < maxElement) {
            if (!arrSet.contains(curr)) {
                return false;
            }

            curr += diff;
        }

        return true;
    }

    public List<Boolean> checkArithmeticSubarrays3(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList();
        for (int i = 0; i < l.length; i++) {
            int[] arr = new int[r[i] - l[i] + 1];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nums[l[i] + j];
            }

            ans.add(check2(arr));
        }

        return ans;
    }

    // from walkccc.me
    public List<Boolean> checkArithmeticSubarrays4(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < l.length; ++i)
            ans.add(isArithmetic(nums, l[i], r[i]));

        return ans;
    }

    private boolean isArithmetic(int[] nums, int l, int r) {
        if (r - l < 2)
            return true;

        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        Set<Integer> numsSet = new HashSet<>();

        for (int i = l; i <= r; ++i) {
            mn = Math.min(mn, nums[i]);
            mx = Math.max(mx, nums[i]);
            numsSet.add(nums[i]);
        }

        if ((mx - mn) % (r - l) != 0)
            return false;

        final int interval = (mx - mn) / (r - l);

        for (int k = 1; k <= r - l; ++k)
            if (!numsSet.contains(mn + k * interval))
                return false;

        return true;
    }

}
