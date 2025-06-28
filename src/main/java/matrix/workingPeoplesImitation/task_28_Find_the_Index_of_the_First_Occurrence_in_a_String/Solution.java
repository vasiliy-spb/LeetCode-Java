package matrix.workingPeoplesImitation.task_28_Find_the_Index_of_the_First_Occurrence_in_a_String;

public class Solution {
    // my solution
    public int strStr(String haystack, String needle) {
        int index = -1;
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            int temp = i;
            while (i < haystack.length() && j < needle.length() && haystack.charAt(i) == needle.charAt(j)) {
                index = index == -1 ? i : index;
                i++;
                j++;
            }
            j--;
            i = temp;
            if (j == needle.length() - 1) {
                break;
            } else {
                index = -1;
                j = 0;
            }
        }
        if (haystack.length() <= index + needle.length()) return -1;
        return index;
    }
}
