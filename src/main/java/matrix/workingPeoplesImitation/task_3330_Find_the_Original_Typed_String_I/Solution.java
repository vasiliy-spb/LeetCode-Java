package matrix.workingPeoplesImitation.task_3330_Find_the_Original_Typed_String_I;

// my solution
public class Solution {
    public int possibleStringCount(String word) {
        int ans = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                ans++;
            }
        }
        return ans;
    }
}
