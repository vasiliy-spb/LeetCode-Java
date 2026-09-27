package matrix.workingPeoplesImitation.task_318_Maximum_Product_of_Word_Lengths;

// my solution (1)
public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        Word[] allWords = new Word[n];
        for (int i = 0; i < n; i++) {
            allWords[i] = new Word(words[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (allWords[i].hasCommonLetters(allWords[j])) {
                    continue;
                }
                ans = Math.max(ans, allWords[i].getLength() * allWords[j].getLength());
            }
        }
        return ans;
    }

    private static class Word {
        private char[] chars;
        private long firstHalf = 0;
        private long secondHalf = 0;

        public Word(String value) {
            this.chars = value.toCharArray();
            init();
        }

        private void init() {
            for (char ch : chars) {
                if (ch > 'm') {
                    int position = ch - 'm';
                    secondHalf |= (1L << position);
                } else {
                    int position = ch - 'a';
                    firstHalf |= (1L << position);
                }
            }
        }

        public boolean hasCommonLetters(Word otherWord) {
            return (getFirstHalf() & otherWord.getFirstHalf()) > 0 ||
                   (getSecondHalf() & otherWord.getSecondHalf()) > 0;
        }

        public long getFirstHalf() {
            return firstHalf;
        }

        public long getSecondHalf() {
            return secondHalf;
        }

        public int getLength() {
            return chars.length;
        }

        @Override
        public String toString() {
            return String.valueOf(chars);
        }
    }
}
