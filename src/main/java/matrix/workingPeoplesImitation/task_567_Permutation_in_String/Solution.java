package matrix.workingPeoplesImitation.task_567_Permutation_in_String;

// my solution
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (n < m) {
            return false;
        }
        int[] letters = new int[26];
        for (int i = 0; i < m; i++) {
            letters[s1.charAt(i) - 'a']--;
            letters[s2.charAt(i) - 'a']++;
        }
        if (hasOnlyZeros(letters)) {
            return true;
        }
        for (int i = m; i < n; i++) {
            letters[s2.charAt(i) - 'a']++;
            letters[s2.charAt(i - m) - 'a']--;
            if (hasOnlyZeros(letters)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasOnlyZeros(int[] letters) {
        for (int l : letters) {
            if (l != 0) {
                return false;
            }
        }
        return true;
    }
}
