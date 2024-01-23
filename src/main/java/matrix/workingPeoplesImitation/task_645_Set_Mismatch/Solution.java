package matrix.workingPeoplesImitation.task_645_Set_Mismatch;

import java.util.*;

public class Solution {

    // my solution
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length + 1];
        for (int num : nums)
            count[num]++;
        int [] result = new int [2];
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 2) result[0] = i;
            if (count[i] == 0) result[1] = i;
        }
        return result;
    }

    // my solution
    public int[] findErrorNums0(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= nums.length; i++)
            set.add(i);

        int [] result = new int [2];

        for (int i : nums)
            if (set.contains(i)) set.remove(i);
            else result[0] = i;

        for (int i : set)
            result[1] = i;

        return result;
    }

    // from walkccc.me
    public int[] findErrorNums2(int[] nums) {
        int duplicate = 0;

        for (final int num : nums) {
            if (nums[Math.abs(num) - 1] < 0)
                duplicate = Math.abs(num);
            else
                nums[Math.abs(num) - 1] *= -1;
        }

        for (int i = 0; i < nums.length; ++i)
            if (nums[i] > 0)
                return new int[] {duplicate, i + 1};

        throw new IllegalArgumentException();
    }

    // from leetcode solutions
    public int[] findErrorNums3(int[] nums) {
        int N = nums.length, sum = N * (N + 1) / 2;
        int[] ans = new int[2];
        boolean[] seen = new boolean[N+1];
        for (int num : nums) {
            sum -= num;
            if (seen[num]) ans[0] = num;
            seen[num] = true;
        }
        ans[1] = sum + ans[0];
        return ans;
    }

    // from leetcode solutions
    public int[] findErrorNums5(int[] nums) {
        int N = nums.length;
        int[] ans = new int[2];
        for (int num : nums)
            nums[(num - 1) % 10000] += 10000;
        for (int i = 0; i < N; i++)
            if (nums[i] > 20000) ans[0] = i + 1;
            else if (nums[i] < 10001) ans[1] = i + 1;
        return ans;
    }

    // from leetcode solutions
    public int[] findErrorNums6(int[] nums) {
        int n = nums.length;
        int[] v = new int[n + 1];
        int missing = 0, duplicate = 0;

        for (int i = 0; i < n; i++) {
            v[nums[i]]++;
        }

        for (int i = 1; i < v.length; i++) {
            if (v[i] == 2) {
                duplicate = i;
            }
            if (v[i] == 0) {
                missing = i;
            }
        }

        return new int[]{duplicate, missing};
    }

}
