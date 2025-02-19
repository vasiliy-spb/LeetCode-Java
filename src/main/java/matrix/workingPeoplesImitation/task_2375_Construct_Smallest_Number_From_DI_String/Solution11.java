package matrix.workingPeoplesImitation.task_2375_Construct_Smallest_Number_From_DI_String;

import java.util.Stack;

// from leetcode code sample (3)
public class Solution11 {
    public static String smallestNumber(String pattern) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[pattern.length() + 1];
        int count = 1;
        for (int i = 0; i <= pattern.length(); i++) {
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                ans[i] = count++;
                while (!st.isEmpty()) {
                    ans[st.pop()] = count++;
                }
            } else {
                st.push(i);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int res : ans) {
            result.append(res);
        }
        return result.toString();
    }

}
