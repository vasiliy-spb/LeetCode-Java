package matrix.workingPeoplesImitation.task_1545_Find_Kth_Bit_in_Nth_Binary_String;

// from leetcode editorial (Approach 1: Brute Force)
public class Solution2 {
    public char findKthBit(int n, int k) {
        StringBuilder sequence = new StringBuilder("0");

        // Generate sequence until we have enough elements or reach nth iteration
        for (int i = 1; i < n && k > sequence.length(); ++i) {
            sequence.append('1');

            // Append the inverted and reversed part of the existing sequence
            for (int j = sequence.length() - 2; j >= 0; --j) {
                char invertedBit = (sequence.charAt(j) == '1') ? '0' : '1';
                sequence.append(invertedBit);
            }
        }

        // Return the kth bit
        return sequence.charAt(k - 1);
    }
}
/*
Approach 1: Brute Force
Intuition

Given that n is relatively small, we can solve this problem by simply simulating the operations.
We'll maintain a string sequence as our binary string.
Next, we run a loop until we reach the nth string or the length of the sequence exceeds k
(in which case, we can terminate early since the required character is already created).

In each iteration, we start by appending 1 to sequence.
Then, we take each bit of the original sequence in reverse, invert it, and append it to the end of sequence.

Finally, once the loop completes, we return the k-1th character (0-indexed) as the result.
Algorithm

    Initialize a string sequence with the initial sequence "0".
    Start a loop that continues until we reach the nth iteration or have generated enough characters:
        Append '1' to the current sequence.
        Start a nested loop to iterate through the existing sequence in reverse order:
            For each bit in the existing sequence (excluding the last '1'):
                Invert the bit (change '0' to '1' or '1' to '0').
                Append the inverted bit to the end of the sequence.
    Once the loop completes, return the k-1th (0-indexed) character of the sequence.

 */