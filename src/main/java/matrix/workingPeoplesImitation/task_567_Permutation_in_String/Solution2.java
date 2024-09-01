package matrix.workingPeoplesImitation.task_567_Permutation_in_String;

// from leetcode editorial (Approach 6: Optimized Sliding Window)
public class Solution2 {
    /* Algorithm

    The last approach can be optimized,
    if instead of comparing all the elements of the hashmaps for every updated s2map corresponding
    to every window of s2 considered, we keep a track of the number of elements which were already matching
    in the earlier hashmap and update just the count of matching elements when we shift the window towards the right.

    To do so, we maintain a count variable, which stores the number of characters(out of the 26 alphabets),
    which have the same frequency of occurence in s1 and the current window in s2. When we slide the window,
    if the deduction of the last element and the addition of the new element leads to a new frequency match
    of any of the characters, we increment the count by 1. If not, we keep the count intact.
    But, if a character whose frequency was the same earlier(prior to addition and removal) is added,
    it now leads to a frequency mismatch which is taken into account by decrementing the same count variable.
    If, after the shifting of the window, the count evaluates to 26, it means all the characters match in frequency totally.
    So, we return a True in that case immediately.
    */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (s1map[i] == s2map[i])
                count++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[r]++;
            if (s2map[r] == s1map[r]) {
                count++;
            } else if (s2map[r] == s1map[r] + 1) {
                count--;
            }
            s2map[l]--;
            if (s2map[l] == s1map[l]) {
                count++;
            } else if (s2map[l] == s1map[l] - 1) {
                count--;
            }
        }
        return count == 26;
    }
}
