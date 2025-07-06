package matrix.workingPeoplesImitation.task_848_Shifting_Letters;

// from leetcode editorial (Approach #1: Prefix Sum [Accepted])
public class Solution3 {
    public String shiftingLetters(String S, int[] shifts) {
        StringBuilder ans = new StringBuilder();
        int X = 0;
        for (int shift : shifts)
            X = (X + shift) % 26;

        for (int i = 0; i < S.length(); ++i) {
            int index = S.charAt(i) - 'a';
            ans.append((char) ((index + X) % 26 + 97));
            X = Math.floorMod(X - shifts[i], 26);
        }

        return ans.toString();
    }
}
