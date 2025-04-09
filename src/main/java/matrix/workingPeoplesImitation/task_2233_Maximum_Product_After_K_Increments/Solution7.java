package matrix.workingPeoplesImitation.task_2233_Maximum_Product_After_K_Increments;

import java.util.Map;
import java.util.TreeMap;

// from leetcode code sample (5)
public class Solution7 {
    int MOD = 1_000_000_007;

    public int maximumProduct(int[] nums, int k) {
        TreeMap<Integer, Long> freqMap = new TreeMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0L) + 1);
        }

        while (k > 0) {
            int current = freqMap.firstKey();
            long count = freqMap.get(current);
            freqMap.remove(current);
            int next = freqMap.isEmpty() ? current + k / (int) count + 1 : freqMap.firstKey();
            long gap = next - current;
            long totalNeeded = gap * count;
            if (totalNeeded <= k) {
                k -= totalNeeded;
                freqMap.put(next, freqMap.getOrDefault(next, 0L) + count);
            } else {
                int add = k / (int) count;
                int remainder = (int) (k % count);
                int newValue = current + add;
                freqMap.put(newValue, freqMap.getOrDefault(newValue, 0L) + (count - remainder));
                if (remainder > 0) {
                    freqMap.put(newValue + 1, freqMap.getOrDefault(newValue + 1, 0L) + remainder);
                }
                k = 0;
            }
        }
        long res = 1;
        for (Map.Entry<Integer, Long> entry : freqMap.entrySet()) {
            int value = entry.getKey();
            long freq = entry.getValue();
            res = (res * modPow(value, freq, MOD)) % MOD;
        }
        return (int) res;
    }

    private long modPow(long a, long b, int mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }
}
