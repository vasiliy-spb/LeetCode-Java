package matrix.workingPeoplesImitation.task_1390_Four_Divisors;

import java.util.*;

// from leetcode editorial (Approach 2: Preprocessing)
public class Solution4 {
    public int sumFourDivisors(int[] nums) {
        // C is the upper bound of the array nums, and C3 is the cube root of C.
        int C = 100000;
        int C3 = 46;

        boolean[] isPrime = new boolean[C + 1];
        Arrays.fill(isPrime, true);
        List<Integer> primes = new ArrayList<Integer>();

        // Sieve of Eratosthenes
        for (int i = 2; i <= C; ++i) {
            if (isPrime[i]) {
                primes.add(i);
            }
            for (int j = i + i; j <= C; j += i) {
                isPrime[j] = false;
            }
        }

        // Sieve of Euler
        /*
        for (int i = 2; i <= C; ++i) {
            if (isPrime[i]) {
                primes.add(i);
            }
            for (int prime : primes) {
                if (i * prime > C) {
                    break;
                }
                isPrime[i * prime] = false;
                if (i % prime == 0) {
                    break;
                }
            }
        }
        */

        // Construct all four factors using the prime table
        Map<Integer, Integer> factor4 = new HashMap<Integer, Integer>();
        for (int prime : primes) {
            if (prime <= C3) {
                factor4.put(
                        prime * prime * prime,
                        1 + prime + prime * prime + prime * prime * prime
                );
            }
        }
        for (int i = 0; i < primes.size(); ++i) {
            for (int j = i + 1; j < primes.size(); ++j) {
                if (primes.get(i) <= C / primes.get(j)) {
                    factor4.put(
                            primes.get(i) * primes.get(j),
                            1 +
                            primes.get(i) +
                            primes.get(j) +
                            primes.get(i) * primes.get(j)
                    );
                } else {
                    break;
                }
            }
        }

        int ans = 0;
        for (int num : nums) {
            if (factor4.containsKey(num)) {
                ans += factor4.get(num);
            }
        }
        return ans;
    }
}
