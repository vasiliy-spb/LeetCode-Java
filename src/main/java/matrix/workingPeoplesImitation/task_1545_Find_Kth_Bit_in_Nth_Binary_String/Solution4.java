package matrix.workingPeoplesImitation.task_1545_Find_Kth_Bit_in_Nth_Binary_String;

// from leetcode editorial (Approach 3: Iterative Divide and Conquer)
public class Solution4 {
    public char findKthBit(int n, int k) {
        int invertCount = 0;
        int len = (1 << n) - 1; // Length of Sn is 2^n - 1

        while (k > 1) {
            // If k is in the middle, return based on inversion count
            if (k == len / 2 + 1) {
                return invertCount % 2 == 0 ? '1' : '0';
            }

            // If k is in the second half, invert and mirror
            if (k > len / 2) {
                k = len + 1 - k; // Mirror position
                invertCount++; // Increment inversion count
            }

            len /= 2; // Reduce length for next iteration
        }

        // For the first position, return based on inversion count
        return invertCount % 2 == 0 ? '0' : '1';
    }
}
/*
Approach 3: Iterative Divide and Conquer
Intuition

We can convert the recursive approach to an iterative one to avoid the excess stack space taken by the recursion.

Our main idea stays the same: start with the largest string and repeatedly halve it
until reaching the smallest string, S1.

In the recursive approach, finding a bit in the second half of the string allowed us to immediately
flip it due to the recursion handling any further inversions.
Since that isn’t possible iteratively, we maintain an invertCount variable to track how many times we enter
an inverted section. Once we find the kth bit, we check the parity of invertCount to determine if it needs to be flipped.

We begin with the largest string length 2n−1 and loop while k is greater than 1. If k is in the middle,
it represents the 1 added during string construction, so we simply return the bit based on invertCount.
If k is in the second half, we mirror k to the corresponding bit in the first half and increment invertCount
to indicate the inversion. Then, we move to the previous string in the series by halving the length.

When the loop completes, k represents the first bit of the string (corresponding to S1).
We return this bit, flipping it if necessary based on invertCount.
Algorithm

    Initialize a variable invertCount to 0 to keep track of the number of inversions.
    Calculate the length of the nth string as 2n−1 using bitwise left shift.
    Enter a loop that continues while k is greater than 1:
        Check if k is exactly in the middle of the current string:
            If true, return '1' if invertCount is even, otherwise return '0'.
        If k is in the second half of the current string:
            Update k to its mirrored position in the first half.
            Increment the invertCount.
        Halve the length of the string for the next iteration.
    After the loop ends (when k reaches 1):
        Return '0' if invertCount is even, otherwise return '1'.

 */