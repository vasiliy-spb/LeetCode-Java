package matrix.workingPeoplesImitation.task_1390_Four_Divisors;

// from leetcode editorial (Approach 1: Enumeration)
public class Solution3 {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            // factorCnt: number of factors
            // factorSum: sum of factors
            int factorCnt = 0;
            int factorSum = 0;
            for (int i = 1; i * i <= num; ++i) {
                if (num % i == 0) {
                    ++factorCnt;
                    factorSum += i;
                    // check if i and num/i are equal;
                    // if not, consider num/i as a new factor.
                    if (i * i != num) {
                        ++factorCnt;
                        factorSum += num / i;
                    }
                }
            }
            if (factorCnt == 4) {
                ans += factorSum;
            }
        }
        return ans;
    }
}
