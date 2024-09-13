package matrix.workingPeoplesImitation.task_1684_Count_the_Number_of_Consistent_Strings;

// from AhlawatAbhishek (https://github.com/AhlawatAbhishek/MayurProgrammingClub/blob/main/LeetCode%20solutions/1684.%20Count%20the%20Number%20of%20Consistent%20Strings)
public class Solution2 {
    public int countConsistentStrings(String allowed, String[] words) {
        int allowedMask = maskString(allowed);
        int consistStrCnt = 0;
        for (var word : words) {
            int wordMask = maskString(word);
            if ((wordMask | allowedMask) == allowedMask) consistStrCnt++;
        }
        return consistStrCnt;
    }

    private int maskString(String str) {
        int strMask = 0;
        for (char ch : str.toCharArray()) {
            int relPos = (ch - 'a');
            strMask |= (1 << relPos);
        }
        return strMask;
    }
}
