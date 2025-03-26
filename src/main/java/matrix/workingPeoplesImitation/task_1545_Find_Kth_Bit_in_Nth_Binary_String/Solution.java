package matrix.workingPeoplesImitation.task_1545_Find_Kth_Bit_in_Nth_Binary_String;

// my solution
public class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder s = new StringBuilder();
        s.append('0');
        while (n-- > 0) {
            s.append('1');
            for (int i = s.length() - 2; i >= 0; i--) {
                s.append(s.charAt(i) == '1' ? '0' : '1');
            }
            if (s.length() >= k) {
                break;
            }
        }
        return s.charAt(k - 1);
    }

    public char findKthBit0(int n, int k) {
        StringBuilder s = new StringBuilder();
        s.append('0');
        while (n-- > 0) {
            StringBuilder temp = new StringBuilder();
            temp.append(s);
            temp.append('1');
            for (int i = s.length() - 1; i >= 0; i--) {
                temp.append(s.charAt(i) == '1' ? '0' : '1');
            }
            s = temp;
            if (s.length() >= k) {
                break;
            }
        }
        return s.charAt(k - 1);
    }
}
