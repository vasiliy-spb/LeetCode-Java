package matrix.workingPeoplesImitation.task_2138_Divide_a_String_Into_Groups_of_Size_k;

// my solution
public class Solution {
    public String[] divideString(String s, int k, char fill) {
        int m = s.length() / k + (s.length() % k == 0 ? 0 : 1);
        String[] ans = new String[m];
        int a = 0;
        for (int i = 0; i < s.length(); i += k) {
            if (i + k < s.length()) {
                ans[a++] = s.substring(i, i + k);
            } else {
                ans[a++] = s.substring(i);
            }
        }
        while (ans[a - 1].length() < k) {
            ans[a - 1] += fill;
        }
        return ans;
    }
}
