package matrix.workingPeoplesImitation.task_2138_Divide_a_String_Into_Groups_of_Size_k;

// from walkccc.me
public class Solution2 {
    public String[] divideString(String s, int k, char fill) {
        String[] ans = new String[(s.length() + k - 1) / k];

        for (int i = 0, j = 0; i < s.length(); i += k)
            ans[j++] = i + k > s.length()
                    ? s.substring(i) + String.valueOf(fill).repeat(i + k - s.length())
                    : s.substring(i, i + k);

        return ans;
    }
}
