package matrix.workingPeoplesImitation.task_2342_Max_Sum_of_a_Pair_With_Equal_Sum_of_Digits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// my solution
public class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> sumNumMap = new HashMap<>();
        for (int num : nums) {
            int sumNumbers = calculateSumOfDigits(num);
            sumNumMap.computeIfAbsent(sumNumbers, list -> new ArrayList<>()).add(num);
        }
        int ans = -1;
        for (List<Integer> list : sumNumMap.values()) {
            int firstMax = 0;
            int secondMax = 0;
            for (int num : list) {
                if (num > firstMax) {
                    secondMax = firstMax;
                    firstMax = num;
                } else if (num > secondMax) {
                    secondMax = num;
                }
                if (firstMax > 0 && secondMax > 0) {
                    ans = Math.max(ans, firstMax + secondMax);
                }
            }
        }
        return ans;
    }

    private int calculateSumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
