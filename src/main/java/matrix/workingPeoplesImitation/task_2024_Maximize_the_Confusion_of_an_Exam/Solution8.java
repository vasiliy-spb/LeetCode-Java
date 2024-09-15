package matrix.workingPeoplesImitation.task_2024_Maximize_the_Confusion_of_an_Exam;

// from leetcode code sample (6)
public class Solution8 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int start = 0;
        int end = 0;
        int tCount = 0;
        int fCount = 0;
        int maxCount = 0;
        while(end < answerKey.length()) {
            if(answerKey.charAt(end) == 'T') {
                tCount++;
            }
            else {
                fCount++;
            }
            // when the minimum changes required to make all 'T' or all 'F' exceeds k
            while(Math.min(tCount, fCount) > k) {
                if(answerKey.charAt(start) == 'T') {
                    tCount--;
                }
                else {
                    fCount--;
                }
                start++;
            }
            maxCount = Math.max(maxCount, end - start + 1);
            end++;
        }
        return maxCount;
    }
}
// Can we use the maximum length at the previous position to help us find the answer for the current position?

// Can we use binary search to find the maximum consecutive same answer at every position?

// An intuitive way to solve this to keep track of the count of Ts and Fs. The window becomes invalid when the minimum of these 2 counts exceeds k.


