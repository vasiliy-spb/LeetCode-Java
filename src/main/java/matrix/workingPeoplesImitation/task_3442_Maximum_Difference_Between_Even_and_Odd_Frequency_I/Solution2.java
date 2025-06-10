package matrix.workingPeoplesImitation.task_3442_Maximum_Difference_Between_Even_and_Odd_Frequency_I;

// my solution 2 (fastest)
public class Solution2 {
    public int maxDifference(String s) {
        int[] frequencies = new int[26];
        int minEven = Integer.MAX_VALUE;
        int maxEven = Integer.MIN_VALUE;
        int minOdd = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;
        for (char ch : s.toCharArray()) {
            frequencies[ch - 'a']++;
        }
        for (int count : frequencies) {
            if (count == 0) {
                continue;
            }
            if (count % 2 == 0) {
                minEven = Math.min(minEven, count);
                maxEven = Math.max(maxEven, count);
            } else {
                minOdd = Math.min(minOdd, count);
                maxOdd = Math.max(maxOdd, count);
            }
        }
        return maxOdd - minEven;
    }
}
