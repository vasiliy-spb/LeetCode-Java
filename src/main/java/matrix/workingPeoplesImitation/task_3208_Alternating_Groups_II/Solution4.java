package matrix.workingPeoplesImitation.task_3208_Alternating_Groups_II;

// from leetcode solutions (2) (slowest)
public class Solution4 {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] col = new int[colors.length + k - 1];
        for (int i = 0; i < colors.length + k - 1; i++) {
            col[i] = colors[i % colors.length];
        }

        // Precompute the alternating pattern hashes
        long h1 = 0, h2 = 0;
        long base = 256; // We can use 256 or any large base value
        long modulus = 1000000007; // Large prime modulus to avoid overflow

        for (int i = 0; i < k; i++) {
            h1 = (h1 * base + (i % 2)) % modulus;
            h2 = (h2 * base + ((i + 1) % 2)) % modulus;
        }

        long rollingHash = 0;
        long basePower = 1; // base^(k-1)

        for (int i = 0; i < k; i++) {
            rollingHash = (rollingHash * base + col[i]) % modulus;
            if (i > 0) basePower = (basePower * base) % modulus;
        }

        int count = 0;
        if (rollingHash == h1 || rollingHash == h2) count++;

        for (int i = k; i < col.length; i++) {
            rollingHash = (rollingHash - col[i - k] * basePower % modulus + modulus) % modulus;
            rollingHash = (rollingHash * base + col[i]) % modulus;
            if (rollingHash == h1 || rollingHash == h2) count++;
        }

        return count;
    }
}
