package matrix.workingPeoplesImitation.task_1684_Count_the_Number_of_Consistent_Strings;

// from leetcode editorial (Approach 2: Boolean Array)
public class Solution4 {
    public int countConsistentStrings(String allowed, String[] words) {
        // Create a boolean array to mark which characters are allowed
        boolean[] isAllowed = new boolean[26];

        // Mark all characters in 'allowed' as true in the isAllowed array
        for (int i = 0; i < allowed.length(); i++) {
            isAllowed[allowed.charAt(i) - 'a'] = true;
        }

        int consistentCount = 0;

        // Iterate through each word in the words array
        for (String word : words) {
            boolean isConsistent = true;

            // Check each character of the current word
            for (int i = 0; i < word.length(); i++) {
                // If any character is not allowed, mark as inconsistent and break
                if (!isAllowed[word.charAt(i) - 'a']) {
                    isConsistent = false;
                    break;
                }
            }

            // If the word is consistent, increment the count
            if (isConsistent) {
                consistentCount++;
            }
        }

        return consistentCount;
    }
}
