package matrix.workingPeoplesImitation.task_762_Prime_Number_of_Set_Bits_in_Binary_Representation;

// from leetcode editorial (Approach #1: Direct)
public class Solution2 {
    public int countPrimeSetBits(int L, int R) {
        int ans = 0;
        for (int x = L; x <= R; ++x) {
            if (isSmallPrime(Integer.bitCount(x))) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isSmallPrime(int x) {
        return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19);
    }
}
