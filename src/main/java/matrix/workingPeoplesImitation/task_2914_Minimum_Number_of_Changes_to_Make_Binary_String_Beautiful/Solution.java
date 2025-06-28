package matrix.workingPeoplesImitation.task_2914_Minimum_Number_of_Changes_to_Make_Binary_String_Beautiful;

// my solution
public class Solution {
    public int minChanges(String s) {
        int count = 0;
        char prev = '\0';
        int length = 0;
        for (char ch : s.toCharArray()) {
            if (ch != prev) {
                if (length % 2 == 0) {
                    prev = ch;
                    length = 1;
                } else {
                    count++;
                    length = 0;
                }
            } else {
                length++;
            }
        }
        return count;
    }
}
