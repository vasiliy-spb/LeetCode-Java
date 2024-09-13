package matrix.workingPeoplesImitation.task_1684_Count_the_Number_of_Consistent_Strings;

// my solution
public class Solution {

    // implementing solution from AhlawatAbhishek (https://github.com/AhlawatAbhishek/MayurProgrammingClub/blob/main/LeetCode%20solutions/1684.%20Count%20the%20Number%20of%20Consistent%20Strings)
    public int countConsistentStrings(String allowed, String[] words) {
        int allowedMask = getMask(allowed);
        int consistentStringCount = 0;
        for (String word : words) {
            int wordMask = getMask(word);
            if ((allowedMask | wordMask) == allowedMask) {
                consistentStringCount++;
            }
        }
        return consistentStringCount;
    }

    private int getMask(String word) {
        int mask = 0;
        for (char letter : word.toCharArray()) {
            int position = letter - 'a';
            mask |= (1 << position);
        }
        return mask;
    }

    // my native solution
    public int countConsistentStrings0(String allowed, String[] words) {
        int count = 0;
        one: for (String word : words) {
            for (char letter : word.toCharArray()) {
                if (allowed.indexOf(letter) < 0) {
                    continue one;
                }
            }
            count++;
        }
        return count;
    }
}
