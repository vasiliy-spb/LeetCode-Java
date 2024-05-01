package matrix.workingPeoplesImitation.task_2000_Reverse_Prefix_of_Word;

public class Solution {

    // my solution
    public String reversePrefix1(String word, char ch) {
        int index = word.indexOf(ch);
        StringBuilder prefix = new StringBuilder(word.substring(0, index + 1));
        return prefix.reverse().toString() + word.substring(index + 1);
    }

    // my solution
    public String reversePrefix(String word, char ch) {
        return new StringBuilder(word.substring(0, word.indexOf(ch) + 1)).reverse() + word.substring(word.indexOf(ch) + 1);
    }
}
