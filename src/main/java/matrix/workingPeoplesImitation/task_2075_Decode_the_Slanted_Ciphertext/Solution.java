package matrix.workingPeoplesImitation.task_2075_Decode_the_Slanted_Ciphertext;

public class Solution {

    // my solution
    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.isEmpty()) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        int step = encodedText.length() / rows + 1;
        int start = 0;
        int index = 0;
        while (index != encodedText.length()) {
            ans.append(encodedText.charAt(index));
            index += step;
            if (index > encodedText.length()) {
                start++;
                index = start;
            }
        }
        while (ans.charAt(ans.length() - 1) == ' ') {
            ans.deleteCharAt(ans.length() - 1);
        }
        return ans.toString();
    }
}
