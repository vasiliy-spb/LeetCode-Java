package matrix.workingPeoplesImitation.task_1545_Find_Kth_Bit_in_Nth_Binary_String;

// from leetcode code sample (3)
public class Solution9 {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder(1 << n);
        sb.append('0');
        for (int i = 2; i <= n; ++i) {
            String invert = invert(sb.toString());
            sb.append('1').append(invert);
            if (sb.length() >= k) {
                return sb.charAt(k - 1);
            }
        }
        return '0';
    }

    private String invert(String x) {
        char[] result = new char[x.length()];
        for (int i = 0; i < x.length(); ++i) {
            result[x.length() - i - 1] = x.charAt(i) == '1' ? '0' : '1';
        }
        return new String(result);
    }
}
