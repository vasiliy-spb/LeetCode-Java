package matrix.workingPeoplesImitation.task_762_Prime_Number_of_Set_Bits_in_Binary_Representation;

import java.util.Set;

// my solution
public class Solution {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> primeNumbers = Set.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (primeNumbers.contains(Integer.bitCount(i))) {
                ans++;
            }
        }
        return ans;
    }
}
