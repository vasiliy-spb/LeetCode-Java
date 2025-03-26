package matrix.workingPeoplesImitation.task_1545_Find_Kth_Bit_in_Nth_Binary_String;

// from leetcode code sample (5)
public class Solution11 {
    public char findKthBit(int n, int k) {
        if (n == 1)
            return '0';
        StringBuilder builder = new StringBuilder();
        builder.append(0);
        for (int i = 2; i <= n; i++) {
            String current = builder.toString();
            builder = generate(builder, new StringBuilder());
            if (builder.length() >= k)
                return builder.charAt(k - 1);
        }
        return builder.charAt(k - 1);
    }

    StringBuilder generate(StringBuilder old, StringBuilder current) {
        String oldS = old.toString();
        current.append(oldS);
        current.append(1);
        old = old.reverse();
        String invert = old.toString().replace('0', '2').replace('1', '0').replace('2', '1');
        current.append(invert);
        return current;
    }
}
