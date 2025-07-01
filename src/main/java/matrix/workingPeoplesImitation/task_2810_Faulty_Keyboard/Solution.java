package matrix.workingPeoplesImitation.task_2810_Faulty_Keyboard;

// my solution
public class Solution {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == 'i') {
                sb.reverse();
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
