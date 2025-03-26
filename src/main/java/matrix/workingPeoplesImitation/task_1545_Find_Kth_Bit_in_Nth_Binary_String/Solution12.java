package matrix.workingPeoplesImitation.task_1545_Find_Kth_Bit_in_Nth_Binary_String;

// from leetcode code sample (6)
public class Solution12 {
    public char findKthBit(int n, int k) {
        String str = "0";
        for (int i = 0; i < n - 1; i++) {
            String temp = str;
            temp = temp.replace("1", "*");
            temp = temp.replace("0", "1");
            temp = temp.replace("*", "0");
            StringBuilder sb = new StringBuilder(temp);
            str = str + "1" + sb.reverse().toString();
            if (str.length() > k) return str.charAt(k - 1);
        }
        return str.charAt(k - 1);
    }
}
