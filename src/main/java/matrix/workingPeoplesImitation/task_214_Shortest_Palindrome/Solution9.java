package matrix.workingPeoplesImitation.task_214_Shortest_Palindrome;

// from leetcode code sample (2)
public class Solution9 {
    public String shortestPalindrome(String s) {
        long hashBase = 29;
        long modValue = (long) 1e9 + 7;
        long forwardHash = 0, reverseHash = 0, powerValue = 1;
        int palindromeEndIndex = -1;

        // Calculate rolling hashes and find the longest palindromic prefix
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // Update forward hash
            forwardHash = (forwardHash * hashBase + (currentChar - 'a' + 1)) %
                    modValue;

            // Update reverse hash
            reverseHash = (reverseHash + (currentChar - 'a' + 1) * powerValue) %
                    modValue;
            powerValue = (powerValue * hashBase) % modValue;

            // If forward and reverse hashes match, update palindrome end index
            if (forwardHash == reverseHash) {
                palindromeEndIndex = i;
            }
        }

        // Find the remaining suffix after the longest palindromic prefix
        String suffix = s.substring(palindromeEndIndex + 1);
        // Reverse the remaining suffix
        StringBuilder reversedSuffix = new StringBuilder(suffix).reverse();

        // Prepend the reversed suffix to the original string and return the result
        return reversedSuffix.append(s).toString();
    }
}
