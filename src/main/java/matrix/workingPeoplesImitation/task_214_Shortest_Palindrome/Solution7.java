package matrix.workingPeoplesImitation.task_214_Shortest_Palindrome;

// from leetcode editorial (Approach 5: Manacher's Algorithm)
public class Solution7 {
    public String shortestPalindrome(String s) {
        // Return early if the string is null or empty
        if (s == null || s.length() == 0) {
            return s;
        }

        // Preprocess the string to handle palindromes uniformly
        String modifiedString = preprocessString(s);
        int[] palindromeRadiusArray = new int[modifiedString.length()];
        int center = 0, rightBoundary = 0;
        int maxPalindromeLength = 0;

        // Iterate through each character in the modified string
        for (int i = 1; i < modifiedString.length() - 1; i++) {
            int mirrorIndex = 2 * center - i;

            // Use previously computed values to avoid redundant calculations
            if (rightBoundary > i) {
                palindromeRadiusArray[i] = Math.min(
                        rightBoundary - i,
                        palindromeRadiusArray[mirrorIndex]
                );
            }

            // Expand around the current center while characters match
            while (
                    modifiedString.charAt(i + 1 + palindromeRadiusArray[i]) ==
                            modifiedString.charAt(i - 1 - palindromeRadiusArray[i])
            ) {
                palindromeRadiusArray[i]++;
            }

            // Update the center and right boundary if the palindrome extends beyond the current boundary
            if (i + palindromeRadiusArray[i] > rightBoundary) {
                center = i;
                rightBoundary = i + palindromeRadiusArray[i];
            }

            // Update the maximum length of palindrome starting at the beginning
            if (i - palindromeRadiusArray[i] == 1) {
                maxPalindromeLength = Math.max(
                        maxPalindromeLength,
                        palindromeRadiusArray[i]
                );
            }
        }

        // Construct the shortest palindrome by reversing the suffix and prepending it to the original string
        StringBuilder suffix = new StringBuilder(
                s.substring(maxPalindromeLength)
        ).reverse();
        return suffix.append(s).toString();
    }

    private String preprocessString(String s) {
        // Add boundaries and separators to handle palindromes uniformly
        StringBuilder sb = new StringBuilder("^");
        for (char c : s.toCharArray()) {
            sb.append("#").append(c);
        }
        return sb.append("#$").toString();
    }
}
