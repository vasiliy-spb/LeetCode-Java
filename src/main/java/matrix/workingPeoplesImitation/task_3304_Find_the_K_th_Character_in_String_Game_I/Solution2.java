package matrix.workingPeoplesImitation.task_3304_Find_the_K_th_Character_in_String_Game_I;

// from leetcode editorial (Approach: Iteration)
public class Solution2 {
    public char kthCharacter(int k) {
        int ans = 0;
        int t;
        while (k != 1) {
            t = 31 - Integer.numberOfLeadingZeros(k);
            if ((1 << t) == k) {
                t--;
            }
            k = k - (1 << t);
            ans++;
        }
        return (char) ('a' + ans);
    }
}
