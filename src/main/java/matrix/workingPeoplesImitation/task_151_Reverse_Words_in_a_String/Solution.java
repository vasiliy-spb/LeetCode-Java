package matrix.workingPeoplesImitation.task_151_Reverse_Words_in_a_String;

class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String [] arr = s.trim().split("\s+");
        for (int i = arr.length - 1; i >= 0; i--) {
            result.append(arr[i]);
            if (i > 0) result.append(" ");
        }
        return result.toString();
    }
}