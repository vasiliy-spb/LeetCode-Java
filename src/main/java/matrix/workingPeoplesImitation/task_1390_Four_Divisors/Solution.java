package matrix.workingPeoplesImitation.task_1390_Four_Divisors;

import java.util.*;

// my solution
public class Solution {
    public int sumFourDivisors(int[] nums) {
        Map<Integer, Integer> divisorSum = new HashMap<>();
        int sum = 0;
        for (int num : nums) {
            if (divisorSum.containsKey(num)) {
                sum += divisorSum.get(num);
            } else {
                Set<Integer> divisors = getDivisors(num);
                if (divisors.size() == 4) {
                    int sumDivisors = calculateSumDivisors(divisors);
                    sum += sumDivisors;
                    divisorSum.put(num, sumDivisors);
                }
            }
        }
        return sum;
    }

    private Set<Integer> getDivisors(int num) {
        Set<Integer> divisors = new HashSet<>();
        divisors.add(1);
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                divisors.add(i);
                if (divisors.size() == 4 && i != num) {
                    return Collections.emptySet();
                }
            }
        }
        return divisors;
    }

    private int calculateSumDivisors(Set<Integer> divisors) {
        return divisors.stream().mapToInt(Integer::intValue).sum();
    }
}
