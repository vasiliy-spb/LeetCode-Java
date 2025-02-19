package matrix.workingPeoplesImitation.task_2375_Construct_Smallest_Number_From_DI_String;

// from leetcode code sample (2)
public class Solution10 {
    public String smallestNumber(String s) {
        StringBuilder res = new StringBuilder(), stack = new StringBuilder();
        for (int i = 0; i <= s.length(); i++) {
            stack.append((char) ('1' + i));
            if (i == s.length() || s.charAt(i) == 'I') {
                res.append(stack.reverse());
                stack = new StringBuilder();
            }
        }
        return res.toString();
    }
}
