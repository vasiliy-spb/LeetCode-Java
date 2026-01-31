package matrix.workingPeoplesImitation.task_744_Find_Smallest_Letter_Greater_Than_Target;

// my solution
public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }
        return letters[0];
    }
}
