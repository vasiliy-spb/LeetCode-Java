package matrix.workingPeoplesImitation.task_1945_Sum_of_Digits_of_String_After_Convert;

// my solution
public class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(ch - 'a' + 1);
        }
        String num = sb.toString();
        while (k > 0) {
            num = transformString(num);
            k--;
        }
        return Integer.parseInt(num);
    }
    private String transformString(String s) {
        int sum = 0;
        for (char ch : s.toCharArray()) {
            sum += ch - '0';
        }
        return String.valueOf(sum);
    }
}
