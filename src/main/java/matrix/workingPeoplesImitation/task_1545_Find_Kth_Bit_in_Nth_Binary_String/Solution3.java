package matrix.workingPeoplesImitation.task_1545_Find_Kth_Bit_in_Nth_Binary_String;

// from leetcode editorial (Approach 2: Recursion)
public class Solution3 {
    public char findKthBit(int n, int k) {
        // Base case: for S1, return '0'
        if (n == 1) return '0';

        // Calculate the length of Sn
        int len = 1 << n; // Equivalent to 2^n

        // If k is in the first half of the string, recurse with n-1
        if (k < len / 2) {
            return findKthBit(n - 1, k);
        }
        // If k is exactly in the middle, return '1'
        else if (k == len / 2) {
            return '1';
        }
        // If k is in the second half of the string
        else {
            // Find the corresponding bit in the first half and invert it
            char correspondingBit = findKthBit(n - 1, len - k);
            return (correspondingBit == '0') ? '1' : '0';
        }
    }
}
/*
Approach 2: Recursion
Intuition

Instead of building the string from the base condition, let’s work backward from the largest string,
which is efficient for large values of k.

According to the problem, each string Sn is formed from Sn−1. So, to find a specific bit in Sn,
we can recursively break down Sn to Sn−1 until reaching S1. This suggests a recursive approach.

We can break down our recursive method into three parts:

    If k is in the first half, it lies in Sn−1. We can recursively call our function with n-1 and the same k.
    If k is exactly in the middle, we know the value is 1 based on the string construction rules, so we return 1.
    The latter half of Sn is actually Sn−1, but flipped and reversed. To account for the reversal,
    we need to find the kth bit from the end. We can do so by calling the findKthBit function on Sn−1 but instead of k,
    we use the length of Sn minus k. The answer we get will be the kth bit but flipped. We just need
    to flip it back before returning it as our final answer.

Algorithm

    If n equals 1, return '0' as the base case.
    Calculate the length of the nth string by left-shifting 1 by n positions.
    Compare k with half of the calculated length and return the result:
        If k is less than half the length, recursively call the function with n-1 and the same k.
        If k is exactly half the length, return '1'.
        If k is greater than half the length:
            Calculate the corresponding position in the first half of the string by subtracting k from the total length.
            Recursively call the function with n-1 and this new position.
            Invert the bit returned from the recursive call (change '0' to '1' or '1' to '0').
            Return the inverted bit.

 */