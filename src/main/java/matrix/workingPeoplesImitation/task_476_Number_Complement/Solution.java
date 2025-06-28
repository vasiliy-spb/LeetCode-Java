package matrix.workingPeoplesImitation.task_476_Number_Complement;

public class Solution {

    // my solution
    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                sb.append(0);
            } else {
                sb.append(1);
            }
        }
        return Integer.valueOf(sb.toString(), 2);
    }

    // from walkccc.me
    public int findComplement2(int num) {
        for (long i = 1; i <= num; i <<= 1)
            num ^= i;
        return num;
    }
}
