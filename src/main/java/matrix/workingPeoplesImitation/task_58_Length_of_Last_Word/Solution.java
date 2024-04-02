package matrix.workingPeoplesImitation.task_58_Length_of_Last_Word;

public class Solution {
    public int lengthOfLastWord(String s) {
        String[] arr = s.split("\\s");
        return arr[arr.length - 1].length();
    }
}
